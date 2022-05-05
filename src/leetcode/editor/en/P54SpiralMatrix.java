//Given an m x n matrix, return all elements of the matrix in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics Array Matrix Simulation 👍 7075 👎 828


package leetcode.editor.en;

// 2022-05-05 12:47:56

import java.util.ArrayList;
import java.util.List;

public class P54SpiralMatrix {
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        spiral(matrix, 0, 0, matrix.length, matrix[0].length, res);
        return res;
    }

    private void spiral(int[][] matrix, int row, int col, int m, int n, List<Integer> res) {
        if (m <= 0 || n <= 0) {
            return;
        }
        // Single row
        if (m == 1) {
            for (int j = 0; j < n; j++) {
                res.add(matrix[row][col + j]);
            }
            return;
        }
        // Single col
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                res.add(matrix[row + i][col]);
            }
            return;
        }

        //  1 1 1 2
        //  4 * * 2
        //  4 * * 2
        //  4 3 3 3

        for (int j = 0; j < n - 1; j++) { // 1
            res.add(matrix[row][col + j]);
        }
        for (int i = 0; i < m - 1; i++) { // 2
            res.add(matrix[row + i][col + n - 1]);
        }
        for (int j = n - 1; j >= 1; j--) { // 3
            res.add(matrix[row + m - 1][col + j]);
        }
        for (int i = m - 1; i >= 1; i--) { // 4
            res.add(matrix[row + i][col]);
        }

        spiral(matrix, row + 1, col + 1, m - 2, n - 2, res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P54SpiralMatrix().new Solution();
        
    } 
}