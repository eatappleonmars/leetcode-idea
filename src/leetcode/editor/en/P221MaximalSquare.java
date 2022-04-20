//Given an m x n binary matrix filled with 0's and 1's, find the largest square 
//containing only 1's and return its area. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
//"1"],["1","0","0","1","0"]]
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: matrix = [["0","1"],["1","0"]]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: matrix = [["0"]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] is '0' or '1'. 
// 
// Related Topics Array Dynamic Programming Matrix 👍 7025 👎 145


package leetcode.editor.en;

// 2022-04-20 09:12:07

public class P221MaximalSquare {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximalSquare(char[][] matrix) {

            int m = matrix.length;
            int n = matrix[0].length;
            int maxLen = 0;

            int[][] dp = new int[m+1][n+1];

            for (int i = m - 1; i >= 0 ; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (matrix[i][j] == '0') {
                        continue;
                    }
                    int minNeighbor = dp[i+1][j];
                    minNeighbor = Math.min(minNeighbor, dp[i][j+1]);
                    minNeighbor = Math.min(minNeighbor, dp[i+1][j+1]);

                    dp[i][j] = 1 + Math.min(dp[i+1][j+1], Math.min(dp[i][j+1], dp[i+1][j]));
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }

            return maxLen * maxLen;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P221MaximalSquare().new Solution();
        
    } 
}