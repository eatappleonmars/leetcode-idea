//You are given an m x n grid where each cell can have one of three values: 
//
// 
// 0 representing an empty cell, 
// 1 representing a fresh orange, or 
// 2 representing a rotten orange. 
// 
//
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten 
//orange becomes rotten. 
//
// Return the minimum number of minutes that must elapse until no cell has a 
//fresh orange. If this is impossible, return -1. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
//Output: -1
//Explanation: The orange in the bottom left corner (row 2, column 0) is never 
//rotten, because rotting only happens 4-directionally.
// 
//
// Example 3: 
//
// 
//Input: grid = [[0,2]]
//Output: 0
//Explanation: Since there are already no fresh oranges at minute 0, the answer 
//is just 0.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] is 0, 1, or 2. 
// 
// Related Topics Array Breadth-First Search Matrix 👍 6517 👎 272


package leetcode.editor.en;

// 2022-05-06 09:54:10

import java.util.LinkedList;
import java.util.Queue;

public class P994RottingOranges {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orangesRotting(int[][] grid) {

            int nRow = grid.length;
            int nCol = grid[0].length;

            int freshCount = 0;
            Queue<int[]> rottenQueue = new LinkedList<>();

            for (int row = 0; row < nRow; row++) {
                for (int col = 0; col < nCol; col++) {
                    int orange = grid[row][col];
                    if (orange == 1) {
                        freshCount += 1;
                    } else if (orange == 2) {
                        rottenQueue.offer(new int[]{row, col});
                    }

                }
            }

            // BFS
            int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
            int time = 0;
            while (!rottenQueue.isEmpty() && freshCount > 0) {
                int size = rottenQueue.size();
                while (size > 0) {
                    size--;
                    int[] rotten = rottenQueue.poll();
                    int row = rotten[0], col = rotten[1];
                    for (int[] dir : directions) {
                        int nextRow = row + dir[0];
                        int nextCol = col + dir[1];
                        if (nextRow < 0 || nextRow >= nRow || nextCol < 0 || nextCol >= nCol || grid[nextRow][nextCol] != 1) {
                            continue;
                        }
                        freshCount--;
                        grid[nextRow][nextCol] = 2;
                        rottenQueue.offer(new int[]{nextRow, nextCol});
                    }

                }
                time++;
            }

            return freshCount == 0 ? time : -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P994RottingOranges().new Solution();
        
    } 
}