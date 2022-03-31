//You are a hiker preparing for an upcoming hike. You are given heights, a 2D 
//array of size rows x columns, where heights[row][col] represents the height of 
//cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to 
//travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can 
//move up, down, left, or right, and you wish to find a route that requires the 
//minimum effort. 
//
// A route's effort is the maximum absolute difference in heights between two 
//consecutive cells of the route. 
//
// Return the minimum effort required to travel from the top-left cell to the 
//bottom-right cell. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
//Output: 2
//Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 
//in consecutive cells.
//This is better than the route of [1,2,2,2,5], where the maximum absolute 
//difference is 3.
// 
//
// Example 2: 
//
// 
//
// 
//Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
//Output: 1
//Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 
//in consecutive cells, which is better than route [1,3,5,3,5].
// 
//
// Example 3: 
//
// 
//Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//
//Output: 0
//Explanation: This route does not require any effort.
// 
//
// 
// Constraints: 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 10⁶ 
// Related Topics Array Binary Search Depth-First Search Breadth-First Search 
//Union Find Heap (Priority Queue) Matrix 👍 2036 👎 96


package leetcode.editor.en;

// 2022-03-30 21:36:49

public class P1631PathWithMinimumEffort {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int m, n;
        private boolean[][] visited;
        private int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        private int res = Integer.MAX_VALUE;

        public int minimumEffortPath(int[][] heights) {
            this.m = heights.length;
            this.n = heights[0].length;
            this.visited = new boolean[m][n];

            dfs(heights, 0, 0, 0);
            return this.res;
        }

        private void dfs(int[][] heights, int currRow, int currCol, int effort) {
            if (effort >= this.res) {
                return;
            }
            if (currRow == m - 1 && currCol == n - 1) {
                this.res = effort;
            }

            visited[currRow][currCol] = true;

            for (int[] dir : directions) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                    continue;
                }
                int nextEffort = Math.abs(heights[nextRow][nextCol] - heights[currRow][currCol]);
                dfs(heights, nextRow, nextCol, Math.max(effort, nextEffort));
            }

            visited[currRow][currCol] = false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1631PathWithMinimumEffort().new Solution();
        
    } 
}