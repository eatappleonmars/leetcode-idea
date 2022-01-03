//You are given an m x n integer matrix grid where each cell is either 0 (empty)
// or 1 (obstacle). You can move up, down, left, or right from and to an empty 
//cell in one step. 
//
// Return the minimum number of steps to walk from the upper left corner (0, 0) 
//to the lower right corner (m - 1, n - 1) given that you can eliminate at most k 
//obstacles. If it is not possible to find such walk return -1. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
//Output: 6
//Explanation: 
//The shortest path without eliminating any obstacle is 10.
//The shortest path with one obstacle elimination at position (3,2) is 6. Such 
//path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
// 
//
// Example 2: 
//
// 
//Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
//Output: -1
//Explanation: We need to eliminate at least two obstacles to find such a walk.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 40 
// 1 <= k <= m * n 
// grid[i][j] is either 0 or 1. 
// grid[0][0] == grid[m - 1][n - 1] == 0 
// 
// Related Topics Array Breadth-First Search Matrix 👍 1695 👎 28


package leetcode.editor.en;

// 2021-12-29 16:05:08

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class P1293ShortestPathInAGridWithObstaclesElimination {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class State {
            int i, j, k, steps;
            public State(int i, int j, int k, int s) {
                this.i = i;
                this.j = j;
                this.k = k;
                this.steps = s;
            }

            @Override
            public boolean equals(Object other) { // no need to compare steps
                if (this == other) return true;
                if (other == null || this.getClass() != other.getClass()) return false;
                State otherState = (State) other;
                return this.i == otherState.i && this.j == otherState.j && this.k == otherState.k;
            }

            @Override
            public int hashCode() {
                return Objects.hash(i, j, k);
            }
        }

        public int shortestPath(int[][] grid, int k) {
            return bfsSolution(grid, k);
        }

        // There are MN grids. Each grid can be visited up to K times.
        // Time: O(MNK)
        private int bfsSolution(int[][] grid, int k) {
            final int m = grid.length - 1;
            final int n = grid[0].length - 1;

            if (k >= m + n) {
                return m + n;
            }

            final State initState = new State(0, 0, k, 0);

            Queue<State> queue = new ArrayDeque<>();
            queue.offer(initState);

            Set<State> seen = new HashSet<>();
            seen.add(initState);

            while (!queue.isEmpty()) {
                State curr = queue.poll();

                if (curr.i == m && curr.j == n) { // reach destination
                    return curr.steps;
                }

                int[] plans = {
                        curr.i-1, curr.j,
                        curr.i+1, curr.j,
                        curr.i, curr.j-1,
                        curr.i, curr.j+1
                };

                for (int i = 0; i < plans.length; i+=2) {
                    int nextRow = plans[i];
                    int nextCol = plans[i + 1];

                    if (nextRow < 0 || nextRow > m || nextCol < 0 || nextCol > n || curr.k - grid[nextRow][nextCol] < 0) {
                        continue;
                    }

                    int nextK = curr.k - grid[nextRow][nextCol];
                    State nextState = new State(nextRow, nextCol, nextK, curr.steps + 1);
                    if (seen.add(nextState)) {
                        queue.offer(nextState);
                    }
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1293ShortestPathInAGridWithObstaclesElimination().new Solution();
        
    } 
}