//There is an infrastructure of n cities with some number of roads connecting 
//these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional 
//road between cities ai and bi. 
//
// The network rank of two different cities is defined as the total number of 
//directly connected roads to either city. If a road is directly connected to both 
//cities, it is only counted once. 
//
// The maximal network rank of the infrastructure is the maximum network rank 
//of all pairs of different cities. 
//
// Given the integer n and the array roads, return the maximal network rank of 
//the entire infrastructure. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
//Output: 4
//Explanation: The network rank of cities 0 and 1 is 4 as there are 4 roads 
//that are connected to either 0 or 1. The road between 0 and 1 is only counted once.
// 
//
// Example 2: 
//
// 
//
// 
//Input: n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
//Output: 5
//Explanation: There are 5 roads that are connected to cities 1 or 2.
// 
//
// Example 3: 
//
// 
//Input: n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
//Output: 5
//Explanation: The network rank of 2 and 5 is 5. Notice that all the cities do 
//not have to be connected.
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 100 
// 0 <= roads.length <= n * (n - 1) / 2 
// roads[i].length == 2 
// 0 <= ai, bi <= n-1 
// ai != bi 
// Each pair of cities has at most one road connecting them. 
// 
// Related Topics Graph 👍 672 👎 125


package leetcode.editor.en;

// 2022-05-17 21:08:08

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P1615MaximalNetworkRank {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {

            boolean[][] graph = new boolean[n][n];
            int[] roadCounts = new int[n];

            for (int[] road : roads) {
                int c1 = road[0], c2 = road[1];
                graph[c1][c2] = true;
                graph[c2][c1] = true;
                roadCounts[c1]++;
                roadCounts[c2]++;
            }

            int maxRank = 0;
            for (int c1 = 0; c1 < n; c1++) {
                boolean[] r1 = graph[c1];
                for (int c2 = c1 + 1; c2 < n; c2++) {
                    maxRank = Math.max(maxRank, roadCounts[c1] + roadCounts[c2] - (r1[c2] ? 1 : 0));
                }
            }
            return maxRank;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1615MaximalNetworkRank().new Solution();
        
    } 
}