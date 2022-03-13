//The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
//such that no two queens attack each other. 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//You may return the answer in any order. 
//
// Each solution contains a distinct board configuration of the n-queens' 
//placement, where 'Q' and '.' both indicate a queen and an empty space, respectively. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as 
//shown above
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [["Q"]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 
// Related Topics Array Backtracking 👍 5353 👎 144


package leetcode.editor.en;

// 2022-03-13 11:31:21

import java.util.ArrayList;
import java.util.List;

public class P51NQueens {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            
            List<List<String>> res = new ArrayList<>();
            int[][] board = new int[n][n];
            
            helper(0, board, res);
            return res;
        }

        private void helper(int currRow, int[][] board, List<List<String>> res) {

            if (currRow == board.length) {
                writeSolution(board, res);
                return;
            }

            for (int currCol = 0; currCol < board.length; currCol++) {
                if (!validate(board, currRow, currCol)) {
                    continue;
                }
                board[currRow][currCol] = 1;
                helper(currRow + 1, board, res);
                board[currRow][currCol] = 0;
            }

        }

        private boolean validate(int[][] board, int currRow, int currCol) {
            int col1 = currCol - 1, col2 = currCol, col3 = currCol + 1;
            for (int row = currRow - 1; row >= 0; row--, col1--, col3++) {
                // up - left
                if (col1 >= 0 && board[row][col1] == 1) {
                    return false;
                }
                if (board[row][col2] == 1) {
                    return false;
                }
                if (col3 < board.length && board[row][col3] == 1) {
                    return false;
                }
            }
            return true;
        }

        private void writeSolution(int[][] board, List<List<String>> res) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    sb.append(board[i][j] == 0 ? '.' : 'Q');
                }
                solution.add(sb.toString());
            }
            res.add(solution);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P51NQueens().new Solution();
        
    } 
}