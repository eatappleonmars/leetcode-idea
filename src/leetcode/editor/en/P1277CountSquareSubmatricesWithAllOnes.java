//Given a m * n matrix of ones and zeros, return how many square submatrices 
//have all ones. 
//
// 
// Example 1: 
//
// 
//Input: matrix =
//[
//  [0,1,1,1],
//  [1,1,1,1],
//  [0,1,1,1]
//]
//Output: 15
//Explanation: 
//There are 10 squares of side 1.
//There are 4 squares of side 2.
//There is  1 square of side 3.
//Total number of squares = 10 + 4 + 1 = 15.
// 
//
// Example 2: 
//
// 
//Input: matrix = 
//[
//  [1,0,1],
//  [1,1,0],
//  [1,1,0]
//]
//Output: 7
//Explanation: 
//There are 6 squares of side 1.  
//There is 1 square of side 2. 
//Total number of squares = 6 + 1 = 7.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 300 
// 1 <= arr[0].length <= 300 
// 0 <= arr[i][j] <= 1 
// 
// Related Topics Array Dynamic Programming Matrix 👍 3230 👎 53


package leetcode.editor.en;

// 2022-04-20 10:20:45

public class P1277CountSquareSubmatricesWithAllOnes {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSquares(int[][] matrix) {

            final int m = matrix.length;
            final int n = matrix[0].length;

            int count = 0;

            int[][] dp = new int[m+1][n+1];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0 ; j--) {
                    if (matrix[i][j] == 0) {
                        continue;
                    }
                    dp[i][j] = 1 + Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
                    count += dp[i][j];
                }
            }

            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1277CountSquareSubmatricesWithAllOnes().new Solution();
        
    } 
}