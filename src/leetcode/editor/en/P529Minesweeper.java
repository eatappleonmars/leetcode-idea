//Let's play the minesweeper game (Wikipedia, online game)! 
//
// You are given an m x n char matrix board representing the game board where: 
//
// 
// 'M' represents an unrevealed mine, 
// 'E' represents an unrevealed empty square, 
// 'B' represents a revealed blank square that has no adjacent mines (i.e., 
//above, below, left, right, and all 4 diagonals), 
// digit ('1' to '8') represents how many mines are adjacent to this revealed 
//square, and 
// 'X' represents a revealed mine. 
// 
//
// You are also given an integer array click where click = [clickr, clickc] 
//represents the next click position among all the unrevealed squares ('M' or 'E'). 
//
// Return the board after revealing this position according to the following 
//rules: 
//
// 
// If a mine 'M' is revealed, then the game is over. You should change it to 
//'X'. 
// If an empty square 'E' with no adjacent mines is revealed, then change it to 
//a revealed blank 'B' and all of its adjacent unrevealed squares should be 
//revealed recursively. 
// If an empty square 'E' with at least one adjacent mine is revealed, then 
//change it to a digit ('1' to '8') representing the number of adjacent mines. 
// Return the board when no more squares will be revealed. 
// 
//
// 
// Example 1: 
// 
// 
//Input: board = [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E",
//"E"],["E","E","E","E","E"]], click = [3,0]
//Output: [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],[
//"B","B","B","B","B"]]
// 
//
// Example 2: 
// 
// 
//Input: board = [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1",
//"B"],["B","B","B","B","B"]], click = [1,2]
//Output: [["B","1","E","1","B"],["B","1","X","1","B"],["B","1","1","1","B"],[
//"B","B","B","B","B"]]
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 50 
// board[i][j] is either 'M', 'E', 'B', or a digit from '1' to '8'. 
// click.length == 2 
// 0 <= clickr < m 
// 0 <= clickc < n 
// board[clickr][clickc] is either 'M' or 'E'. 
// 
//
// Related Topics Array Depth-First Search Breadth-First Search Matrix 👍 1663 ?
//? 954


package leetcode.editor.en;

// 2023-01-08 12:49:44

public class P529Minesweeper {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] DIR = {
                {-1,0}, {1,-1},{0,1}, {1,1},
                {1,0}, {-1,1},{0,-1}, {-1,-1}
        };

        private int NROWS, NCOLS;


        public char[][] updateBoard(char[][] board, int[] click) {
            int r = click[0];
            int c = click[1];
            if (board[r][c] == 'M') {
                board[r][c] = 'X';
            } else {
                NROWS = board.length;
                NCOLS = board[0].length;
                updateBoard(board, click[0], click[1]);
            }
            return board;
        }

        private void updateBoard(char[][] board, int r, int c) {
            if (r < 0 || r >= NROWS || c < 0 || c >= NCOLS) {
                return;
            }
            char square = board[r][c];
            if (square != 'E') { // No action if this is not the 'E' square
                return;
            }
            // Count the number of mines around it
            int mines = 0;
            for (int[] dir : DIR) {
                int rr = r + dir[0];
                int cc = c + dir[1];
                if (rr >= 0 && rr < NROWS && cc >= 0 && cc < NCOLS) {
                    mines += board[rr][cc] == 'M' ? 1 : 0;
                }
            }
            if (mines == 0) { // No mines. Continue to reveal all adjacent 'E' squares
                board[r][c] = 'B';
                for (int[] dir : DIR) {
                    int rr = r + dir[0];
                    int cc = c + dir[1];
                    updateBoard(board, rr, cc);
                }
            } else { // There is at least one mine around. Reveal the count only.
                board[r][c] = ((char) (mines + '0'));
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P529Minesweeper().new Solution();
        
    } 
}