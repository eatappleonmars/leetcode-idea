//Given an m x n 2D binary grid grid which represents a map of '1's (land) and 
//'0's (water), return the number of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all 
//surrounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Matrix 👍 12816 👎 316


package leetcode.editor.en;

// 2022-03-15 10:30:13

public class P200NumberOfIslands {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int numRow, numCol;
        private boolean[][] visited;

        private int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        public int numIslands(char[][] grid) {

            this.numRow = grid.length;
            this.numCol = grid[0].length;
            this.visited = new boolean[numRow][numCol];

            int count = 0;

            for (int i = 0; i < numRow; i++) {
                for (int j = 0; j < numCol; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        dfs(i, j, grid, visited);
                        count++;
                    }
                }
            }

            return count;
        }

        // grid[row][col] == '1'. Explore and visit all "1"s that connect to it
        private void dfs(int row, int col, char[][] grid, boolean[][] visited) {

            visited[row][col] = true;

            for (int[] dir : direction) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (nextRow < 0 || nextRow >= numRow || nextCol < 0 || nextCol >= numCol) {
                    continue;
                }

                if (visited[nextRow][nextCol]) {
                    continue;
                }

                if (grid[nextRow][nextCol] == '1') {
                    dfs(nextRow, nextCol, grid, visited);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P200NumberOfIslands().new Solution();
        
    } 
}