//Given an m x n integer matrix matrix, if an element is 0, set its entire row 
//and column to 0's. 
//
// You must do it in place. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -2³¹ <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 
// Follow up: 
//
// 
// A straightforward solution using O(mn) space is probably a bad idea. 
// A simple improvement uses O(m + n) space, but still not the best solution. 
// Could you devise a constant space solution? 
// 
// Related Topics Array Hash Table Matrix 👍 6902 👎 488


package leetcode.editor.en;

// 2022-05-07 14:18:45

import java.util.Arrays;

public class P73SetMatrixZeroes {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            boolean firstRowZero = false, firstColZero = false;
            // First row
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[0][col] == 0) {
                    firstRowZero = true;
                    break;
                }
            }
            // First col
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][0] == 0) {
                    firstColZero = true;
                    break;
                }
            }
            // Other
            for (int row = 1; row < matrix.length; row++) {
                for (int col = 1; col < matrix[0].length; col++) {
                    if (matrix[row][col] == 0) {
                        matrix[row][0] = 0;
                        matrix[0][col] = 0;
                    }
                }
            }

            for (int row = 1; row < matrix.length; row++) {
                for (int col = 1; col < matrix[0].length; col++) {
                    if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                        matrix[row][col] = 0;
                    }
                }
            }

            if (firstRowZero) {
                Arrays.fill(matrix[0], 0);

            }
            if (firstColZero) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][0] = 0;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P73SetMatrixZeroes().new Solution();
        
    } 
}