//Write an algorithm to determine if a number n is happy. 
//
// A happy number is a number defined by the following process: 
//
// 
// Starting with any positive integer, replace the number by the sum of the 
//squares of its digits. 
// Repeat the process until the number equals 1 (where it will stay), or it 
//loops endlessly in a cycle which does not include 1. 
// Those numbers for which this process ends in 1 are happy. 
// 
//
// Return true if n is a happy number, and false if not. 
//
// 
// Example 1: 
//
// 
//Input: n = 19
//Output: true
//Explanation:
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
// 
//
// Example 2: 
//
// 
//Input: n = 2
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics Hash Table Math Two Pointers 👍 8994 👎 1167


package leetcode.editor.en;

// 2023-07-09 14:43:43

import java.util.HashSet;
import java.util.Set;

public class P202HappyNumber {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            return sol1UsingSet(n);
//            return sol2UsingFloydCycleFindingAlgorithm(n);
        }

        private boolean sol1UsingSet(int n) {
            Set<Integer> seen = new HashSet<>();
            while (n != 1 && !seen.contains(n)) {
                seen.add(n);
                n = getNextN(n);
            }
            return n == 1;
        }

        private boolean sol2UsingFloydCycleFindingAlgorithm(int n) {
            int slow = n;
            int fast = getNextN(n);
            while (fast != 1 && slow != fast) {
                slow = getNextN(slow);
                fast = getNextN(getNextN(fast));
            }
            return fast == 1;
        }

        private int getNextN(int n) {
            int nextN = 0;
            while (n != 0) {
                int digit = n % 10;
                nextN += (digit * digit);
                n /= 10;
            }
            return nextN;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P202HappyNumber().new Solution();
        
    } 
}