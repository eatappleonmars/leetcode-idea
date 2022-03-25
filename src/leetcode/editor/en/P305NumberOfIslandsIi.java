//You are given an empty 2D binary grid grid of size m x n. The grid represents 
//a map where 0's represent water and 1's represent land. Initially, all the 
//cells of grid are water cells (i.e., all the cells are 0's). 
//
// We may perform an add land operation which turns the water at position into 
//a land. You are given an array positions where positions[i] = [ri, ci] is the 
//position (ri, ci) at which we should operate the iᵗʰ operation. 
//
// Return an array of integers answer where answer[i] is the number of islands 
//after turning the cell (ri, ci) into a land. 
//
// An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all 
//surrounded by water. 
//
// 
// Example 1: 
//
// 
//Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
//Output: [1,1,2,3]
//Explanation:
//Initially, the 2d grid is filled with water.
//- Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. We 
//have 1 island.
//- Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. We 
//still have 1 island.
//- Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. We 
//have 2 islands.
//- Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. We 
//have 3 islands.
// 
//
// Example 2: 
//
// 
//Input: m = 1, n = 1, positions = [[0,0]]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n, positions.length <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// positions[i].length == 2 
// 0 <= ri < m 
// 0 <= ci < n 
// 
//
// 
// Follow up: Could you solve it in time complexity O(k log(mn)), where k == 
//positions.length? 
// Related Topics Array Union Find 👍 1385 👎 42


package leetcode.editor.en;

// 2022-03-22 09:25:59

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P305NumberOfIslandsIi {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int numRow, numCol;

        private int[][] direction = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        public List<Integer> numIslands2(int m, int n, int[][] positions) {

            this.numRow = m;
            this.numCol = n;

            int[] parents = new int[m * n];
            Arrays.fill(parents, -1);

            int count = 0;
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < positions.length; i++) {
                int row = positions[i][0];
                int col = positions[i][1];
                int currRoot = getIndex(row, col);
                // Skip duplicate position
                if (parents[currRoot] != -1) {
                    res.add(count);
                    continue;
                }
                // Assume it's isolated land for the moment
                parents[currRoot] = currRoot; // Current root equals index
                count++;
                // Check neighbors
                for(int[] dir : direction) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];
                    int neighborIndex = getIndex(nextRow, nextCol);
                    // Skip out-of-boundary and water
                    if (outOfBoundary(nextRow, nextCol) || parents[neighborIndex] == -1) {
                        continue;
                    }
                    // Found neighbor. Union.
                    int neighborRoot = findRoot(parents, neighborIndex);
                    if (currRoot != neighborRoot) {
                        parents[neighborRoot] = currRoot;
                        count--;
                    }
                }

                res.add(count);
            }
            return res;
        }

        private int findRoot(int[] parents, int index) {
            int parent = parents[index];
            if (index == parent) {
                return index;
            }
            return findRoot(parents, parent);
        }

        private int getIndex(int row, int col) {
            return row * numCol + col; // 1-based index
        }

        private boolean outOfBoundary(int row, int col) {
            return row < 0 || row >= numRow || col < 0 || col >= numCol;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P305NumberOfIslandsIi().new Solution();
        
    } 
}