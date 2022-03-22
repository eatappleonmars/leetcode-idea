//Given an m x n matrix board containing 'X' and 'O', capture all regions that 
//are 4-directionally surrounded by 'X'. 
//
// A region is captured by flipping all 'O's into 'X's in that surrounded 
//region. 
//
// 
// Example 1: 
//
// 
//Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X",
//"O","X","X"]]
//Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X",
//"X"]]
//Explanation: Surrounded regions should not be on the border, which means that 
//any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not 
//on the border and it is not connected to an 'O' on the border will be flipped to 
//'X'. Two cells are connected if they are adjacent cells connected horizontally 
//or vertically.
// 
//
// Example 2: 
//
// 
//Input: board = [["X"]]
//Output: [["X"]]
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] is 'X' or 'O'. 
// 
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Matrix 👍 4581 👎 1129


package leetcode.editor.en;

// 2022-03-21 16:16:13

public class P130SurroundedRegions {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int numRow, numCol;
        private int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        public void solve(char[][] board) {

            this.numRow = board.length;
            this.numCol = board[0].length;

            dfs(board);
        }

        // DFS Entry
        private void dfs(char[][] board) {

            boolean[][] visited = new boolean[numRow][numCol];

            int lastRow = numRow - 1;

            // All 'O' connected to boundary 'O' cannot be flipped
            for (int col = 0; col < numCol; col++) {
                if (board[0][col] == 'O' && !visited[0][col]) {
                    dfs(board, 0, col, visited);
                }
                if (board[lastRow][col] == 'O' && !visited[lastRow][col]) {
                    dfs(board, lastRow, col, visited);
                }
            }

            int lastCol = numCol - 1;

            // All unvisited 'O' are isolated, hence can be flippec
            for (int row = 0; row < numRow; row++) {
                if (board[row][0] == 'O' && !visited[row][0]) {
                    dfs(board, row, 0, visited);
                }
                if (board[row][lastCol] == 'O' && !visited[row][lastCol]) {
                    dfs(board, row, lastCol, visited);
                }
            }

            for (int row = 0; row < numRow; row++) {
                for (int col = 0; col < numCol; col++) {
                    if (board[row][col] == 'O' && !visited[row][col]) {
                        board[row][col] = 'X';
                    }
                }
            }
        }

        private void dfs(char[][] board, int row, int col, boolean[][] visited) {

            visited[row][col] = true;

            for (int[] dir : direction) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (outOfBoundary(nextRow, nextCol) || board[nextRow][nextCol] == 'X' || visited[nextRow][nextCol]) {
                    continue;
                }
                dfs(board, nextRow, nextCol, visited);
            }
        }

        private boolean outOfBoundary(int row, int col) {
            return row <= 0 || row >= numRow - 1 || col <= 0 || col >= numCol - 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P130SurroundedRegions().new Solution();
        
    } 
}