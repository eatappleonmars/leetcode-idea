//Given an m x n matrix mat, return an array of all the elements of the array 
//in a diagonal order. 
//
// 
// Example 1: 
// 
// 
//Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,4,7,5,3,6,8,9]
// 
//
// Example 2: 
//
// 
//Input: mat = [[1,2],[3,4]]
//Output: [1,2,3,4]
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
//
// Related Topics Array Matrix Simulation 👍 2715 👎 591


package leetcode.editor.en;

// 2022-12-11 12:31:26

public class P498DiagonalTraverse {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int[][] INCR = {
                {-1, 1}, {1, -1}
        };

        private int nRows, nCols;
        private int row = 0, col = 0;

        public int[] findDiagonalOrder(int[][] mat) {
            nRows = mat.length;
            nCols = mat[0].length;
            final int N = nRows * nCols;
            final int[] res = new int[N];

            int moveDir = 0;
            int index = 0;
            while (index < N) {
                int[] incr = INCR[moveDir];
                int numElements = moveDir == 0 ? Math.min(row+1, nCols-col) : Math.min(nRows-row, col+1);
                while (numElements-- > 0) {
                    // System.out.println(row + ", " + col);
                    res[index++] = mat[row][col];
                    row += incr[0];
                    col += incr[1];
                }
                // Change direction
                moveDir = 1 - moveDir;
                getStartingPoint(moveDir);
            }
            return res;
        }

        private void getStartingPoint(int action) {
            if (action == 0) { // will move up right
                if (row < nRows) {
                    col = 0;
                } else {
                    row -= 1;
                    col += 2;
                }
            } else { // will move down left
                if (col < nCols) {
                    row = 0;
                } else {
                    row += 2;
                    col -= 1;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P498DiagonalTraverse().new Solution();
        
    } 
}