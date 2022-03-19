//Given an integer n, find a sequence that satisfies all of the following: 
//
// 
// The integer 1 occurs once in the sequence. 
// Each integer between 2 and n occurs twice in the sequence. 
// For every integer i between 2 and n, the distance between the two 
//occurrences of i is exactly i. 
// 
//
// The distance between two numbers on the sequence, a[i] and a[j], is the 
//absolute difference of their indices, |j - i|. 
//
// Return the lexicographically largest sequence. It is guaranteed that under 
//the given constraints, there is always a solution. 
//
// A sequence a is lexicographically larger than a sequence b (of the same 
//length) if in the first position where a and b differ, sequence a has a number 
//greater than the corresponding number in b. For example, [0,1,9,0] is 
//lexicographically larger than [0,1,5,6] because the first position they differ is at the third 
//number, and 9 is greater than 5. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: [3,1,2,3,2]
//Explanation: [2,3,2,1,3] is also a valid sequence, but [3,1,2,3,2] is the 
//lexicographically largest valid sequence.
// 
//
// Example 2: 
//
// 
//Input: n = 5
//Output: [5,3,1,4,3,5,2,4,2]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 
// Related Topics Array Backtracking 👍 364 👎 33


package leetcode.editor.en;

// 2022-03-18 14:47:41

public class P1718ConstructTheLexicographicallyLargestValidSequence {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructDistancedSequence(int n) {
            int[] res = new int[2 * n - 1];
            boolean[] visited = new boolean[n + 1];
            dfs(0, res, visited, 0, n);
            return res;
        }

        // DFS: all permutation
        // Digits in sequence[0, seqIndex) have been placed into res successfully.
        // Keep searching with remaining digits in sequence[seqIndex : END).
        private boolean dfs(int resIndex, int[] res, boolean[] visited, int visitedCount, final int n) {
            // Base case when done
            if (visitedCount == n) {
                return true;
            }
            // Current position in res has been taken, try next
            if (res[resIndex] != 0) {
                return dfs(resIndex + 1, res, visited, visitedCount, n);
            }

            // Permute by swapping i-th and start-th number
            for (int digit = n; digit > 0; digit--) {
                if (visited[digit]) {
                    continue;
                }
                // In case of digit not being 1, need to double-check its second placement index
                if (validateAndPlaceDigit(digit, resIndex, res, visited)) {
                    // Continue with subsequence
                    if (dfs(resIndex + 1, res, visited, visitedCount + 1, n)) {
                        return true;
                    }
                    // backtrack digit placement
                    res[resIndex] = 0;
                    if (digit != 1) {
                        res[resIndex + digit] = 0;
                    }
                    visited[digit] = false;
                }
            }
            return false;
        }

        // 14,12,13,9,7,11,4,1,10,8,4,7,9,12,14,13,11,8,10,5,6,2,3,2,5,3,6
        // 14,12,13,9,7,11,4,1,10,8,4,7,9,12,14,13,11,8,10,6,3,5,2,3,2,6,5

        // Given resIndex is available, check if digit can be placed into res
        private boolean validateAndPlaceDigit(int digit, int resIndex, int[] res, boolean[] visited) {
            res[resIndex] = digit;
            if (digit != 1) {
                int secondResIndex = resIndex + digit;
                if (secondResIndex < res.length && res[secondResIndex] == 0) {
                    res[secondResIndex] = digit;
                } else {
                    res[resIndex] = 0; // restore
                    return false;
                }
            }
            visited[digit] = true;
            return true;
        }

        private void swap(int[] sequence, int i, int j) {
            int n = sequence[i];
            sequence[i] = sequence[j];
            sequence[j] = n;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1718ConstructTheLexicographicallyLargestValidSequence().new Solution();
        
    } 
}