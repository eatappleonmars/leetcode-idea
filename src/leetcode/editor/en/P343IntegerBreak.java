//Given an integer n, break it into the sum of k positive integers, where k >= 2
//, and maximize the product of those integers. 
//
// Return the maximum product you can get. 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 1
//Explanation: 2 = 1 + 1, 1 × 1 = 1.
// 
//
// Example 2: 
//
// 
//Input: n = 10
//Output: 36
//Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 58 
// 
// Related Topics Math Dynamic Programming 👍 2736 👎 327


package leetcode.editor.en;

// 2022-05-03 09:58:14

public class P343IntegerBreak {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                // Convert from max with cut to max including no-cut
                dp[i-1] = Math.max(dp[i-1], i-1);
                for (int j = 1; j <= i/2; j++) {
                    dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
                }
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P343IntegerBreak().new Solution();
        
    } 
}