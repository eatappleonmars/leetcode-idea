//There is an m x n rectangular island that borders both the Pacific Ocean and 
//Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and 
//the Atlantic Ocean touches the island's right and bottom edges. 
//
// The island is partitioned into a grid of square cells. You are given an m x 
//n integer matrix heights where heights[r][c] represents the height above sea 
//level of the cell at coordinate (r, c). 
//
// The island receives a lot of rain, and the rain water can flow to 
//neighboring cells directly north, south, east, and west if the neighboring cell's height 
//is less than or equal to the current cell's height. Water can flow from any cell 
//adjacent to an ocean into the ocean. 
//
// Return a 2D list of grid coordinates result where result[i] = [ri, ci] 
//denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic 
//oceans. 
//
// 
// Example 1: 
//
// 
//Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//
//Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// 
//
// Example 2: 
//
// 
//Input: heights = [[2,1],[1,2]]
//Output: [[0,0],[0,1],[1,0],[1,1]]
// 
//
// 
// Constraints: 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
// Related Topics Array Depth-First Search Breadth-First Search Matrix 👍 3316 ?
//? 762


package leetcode.editor.en;

// 2022-03-14 21:24:04

import java.util.ArrayList;
import java.util.List;

public class P417PacificAtlanticWaterFlow {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        private int numRow, numCol;
        private boolean[][] pacific, atlantic;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {

            this.numRow = heights.length;
            this.numCol = heights[0].length;
            this.pacific = new boolean[numRow][numCol];
            this.atlantic = new boolean[numRow][numCol];

            for (int i = 0; i < numRow; i++) {
                dfs(i, 0, heights, pacific);
                dfs(i, numCol - 1, heights, atlantic);
            }

            for (int j = 0; j < numCol; j++) {
                dfs(0, j, heights, pacific);
                dfs(numRow - 1, j, heights, atlantic);
            }

            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < numRow; i++) {
                for (int j = 0; j < numCol; j++) {
                    if (pacific[i][j] && atlantic[i][j]) {
                        res.add(List.of(i, j));
                    }
                }
            }

            return res;
        }

        // Find all cells that can finally reach heights[row][col]
        private void dfs(int row, int col, int[][] heights, boolean[][] reachable) {

            reachable[row][col] = true;

            for (int[] dir : direction) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (nextRow < 0 || nextRow >= numRow || nextCol < 0 || nextCol >= numCol) {
                    continue;
                }

                if (reachable[nextRow][nextCol]) {
                    continue;
                }

                if (heights[nextRow][nextCol] < heights[row][col]) {
                    continue;
                }

                dfs(nextRow, nextCol, heights, reachable);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P417PacificAtlanticWaterFlow().new Solution();
        
    } 
}