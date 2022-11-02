//Given an n x n binary matrix grid, return the length of the shortest clear 
//path in the matrix. If there is no clear path, return -1. 
//
// A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0
//)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that: 
//
// 
// All the visited cells of the path are 0. 
// All the adjacent cells of the path are 8-directionally connected (i.e., they 
//are different and they share an edge or a corner). 
// 
//
// The length of a clear path is the number of visited cells of this path. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[0,1],[1,0]]
//Output: 2
// 
//
// Example 2: 
// 
// 
//Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] is 0 or 1 
// 
//
// Related Topics Array Breadth-First Search Matrix 👍 4112 👎 173


package leetcode.editor.en;

// 2022-11-01 21:55:39

import java.util.ArrayDeque;
import java.util.Queue;

public class P1091ShortestPathInBinaryMatrix {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int N;
        private int[][] DIRECTION = {
                {1, 1}, {0, 1}, {1, 0}, {1, -1}, {-1, 1},
                {0, -1}, {-1, 0}, {-1, -1}
        };

        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid[0][0] == 1) {
                return -1;
            }
            N = grid.length;
            int[][] shortestPath = new int[N][N];
            shortestPath[0][0] = 1;
            bfs(grid, shortestPath);
            return shortestPath[N-1][N-1] == 0 ? -1 : shortestPath[N-1][N-1];

        }

        private void bfs(int[][] grid, int[][] shortestPath) {
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{0, 0});
            int degree = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                degree++;
                while (size > 0) {
                    size--;
                    int[] point = queue.poll();
                    int x = point[0];
                    int y = point[1];
                    for (int[] dir : DIRECTION) {
                        int nextX = x + dir[0];
                        int nextY = y + dir[1];
                        if (outOfBoundary(nextX, nextY) || grid[nextX][nextY] == 1 || shortestPath[nextX][nextY] != 0) {
                            continue;
                        }
                        shortestPath[nextX][nextY] = degree;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }

        private boolean outOfBoundary(int x, int y) {
            return x < 0 || x >= N || y < 0 || y >= N;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1091ShortestPathInBinaryMatrix().new Solution();
        
    } 
}