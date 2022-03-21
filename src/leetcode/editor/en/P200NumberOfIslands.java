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

import java.util.ArrayDeque;
import java.util.Queue;

public class P200NumberOfIslands {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int numRow, numCol;
        int count = 0;

        private int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        public int numIslands(char[][] grid) {

            this.numRow = grid.length;
            this.numCol = grid[0].length;

            // Multiple solutions
//            return dfs(grid);
//            return bfs(grid);
            return uf(grid);
        }

        // DFS Entry
        private int dfs(char[][] grid) {

            for (int i = 0; i < numRow; i++) {
                for (int j = 0; j < numCol; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        dfs(i, j, grid);
                    }
                }
            }
            return count;
        }

        // DFS Helper
        // grid[row][col] == '1'. Explore and visit all "1"s that connect to it
        private void dfs(int row, int col, char[][] grid) {

//            visited[row][col] = true;
            grid[row][col] = '0';

            for (int[] dir : direction) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (!boundaryCheck(nextRow, nextCol)) {
                    continue;
                }

                if (grid[nextRow][nextCol] == '1') {
                    dfs(nextRow, nextCol, grid);
                }
            }
        }

        // BFS Entry
        private int bfs(char[][] grid) {

            Queue<int[]> queue = new ArrayDeque<>();

            for (int i = 0; i < numRow; i++) {
                for (int j = 0; j < numCol; j++) {
                    if (grid[i][j] == '0') {
                        continue;
                    }
                    count++;
                    queue.offer(new int[]{i, j});
                    grid[i][j] = '0';

                    while (!queue.isEmpty()) {
                        int[] land = queue.poll();
                        int row = land[0];
                        int col = land[1];

                        for (int[] dir : direction) {
                            int nextRow = row + dir[0];
                            int nextCol = col + dir[1];

                            if (boundaryCheck(nextRow, nextCol) && grid[nextRow][nextCol] == '1') {
                                queue.offer(new int[]{nextRow, nextCol});
                                grid[nextRow][nextCol] = '0';
                            }
                        }
                    }

                }
            }

            return count;
        }

        // UnionFind Entry
        private int uf(char[][] grid) {
            int[] parents = new int[getIndex(numRow, numCol) + 1];
            // Initialize
            for (int i = 0; i < numRow; i++) {
                for (int j = 0; j < numCol; j++) {
                    if (grid[i][j] == '1') {
                        int index = getIndex(i, j);
                        parents[index] = index;
                        count++;
                    }
                }
            }
            // union find
            for (int i = 0; i < numRow; i++) {
                for (int j = 0; j < numCol; j++) {
                    if (grid[i][j] == '1') {
                        grid[i][j] = '0';
                        int currIndex = getIndex(i, j);
                        for (int[] dir : direction) {
                            int nextRow = i + dir[0];
                            int nextCol = j + dir[1];
                            if (!boundaryCheck(nextRow, nextCol) || grid[nextRow][nextCol] == '0') {
                                continue;
                            }
                            int nextIndex = getIndex(nextRow, nextCol);
                            union(parents, currIndex, nextIndex);
                        }
                    }
                }
            }

            return count;
        }

        private void union(int[] parents, int i, int j) {
            int iRoot = find(parents, i);
            int jRoot = find(parents, j);
            if (iRoot != jRoot) {
                parents[jRoot] = parents[iRoot];
                count--;
            }
        }

        private int find(int[] parents, int index) {
            if (parents[index] == index) {
                return index;
            }
            int parentIndex = parents[index];
            return find(parents, parentIndex);
        }

        private int getIndex(int i, int j) {
            return i * numCol +  j;
        }

        private boolean boundaryCheck(int i, int j) {
            return i >= 0 && i < numRow && j >= 0 && j < numCol;
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