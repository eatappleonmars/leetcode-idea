//Given a 1-indexed array of integers numbers that is already sorted in non-
//decreasing order, find two numbers such that they add up to a specific target 
//number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1
// < index2 < numbers.length. 
//
// Return the indices of the two numbers, index1 and index2, added by one as an 
//integer array [index1, index2] of length 2. 
//
// The tests are generated such that there is exactly one solution. You may not 
//use the same element twice. 
//
// Your solution must use only constant extra space. 
//
// 
// Example 1: 
//
// 
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We 
//return [1, 2].
// 
//
// Example 2: 
//
// 
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We 
//return [1, 3].
// 
//
// Example 3: 
//
// 
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
//Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We 
//return [1, 2].
// 
//
// 
// Constraints: 
//
// 
// 2 <= numbers.length <= 3 * 10⁴ 
// -1000 <= numbers[i] <= 1000 
// numbers is sorted in non-decreasing order. 
// -1000 <= target <= 1000 
// The tests are generated such that there is exactly one solution. 
// 
//
// Related Topics Array Two Pointers Binary Search 👍 9945 👎 1250


package leetcode.editor.en;

// 2023-07-05 23:04:08

public class P167TwoSumIiInputArrayIsSorted {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            return sol1(numbers, target);
//            return sol2BinarySearch(numbers, target);
        }

        // O(n)
        private int[] sol1(int[] numbers, int target) {
            int i = 0, j = numbers.length - 1;
            while (true) {
                int sum = numbers[i] + numbers[j];
                if (sum == target) {
                    break;
                }
                if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
            return new int[]{i + 1, j + 1};
        }

        // O(n*log(n))
        private int[] sol2BinarySearch(int[] numbers, int target) {
            int j = numbers.length - 1;
            for (int i = 0; i < numbers.length; i++) {
                int a = numbers[i];
                // Fix a, search b which is target - a, within range [i+1, j]
                j = sol1Helper(numbers, i + 1, j, target - a);
                if (a + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
            // Will never reach here
            return new int[2];
        }

        // Given numbers[i:j], find the index such that numbers[i] == target
        // If cannot find the index, return the smallest index such that numbers[i] > target
        private int sol1Helper(int[] numbers, int i, int j, int target) {
            while (i < j) {
                int k = i + (j - i) / 2;
                if (target == numbers[k]) {
                    return k;
                }
                if (numbers[k] < target) {
                    i = k + 1; // no need to keep index k
                } else {
                    j = k; // need to keep index k because this is a valid candidate
                }

            }
            return i;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P167TwoSumIiInputArrayIsSorted().new Solution();
        
    } 
}