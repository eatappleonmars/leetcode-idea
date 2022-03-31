//There are n computers numbered from 0 to n - 1 connected by ethernet cables 
//connections forming a network where connections[i] = [ai, bi] represents a 
//connection between computers ai and bi. Any computer can reach any other computer 
//directly or indirectly through the network. 
//
// You are given an initial computer network connections. You can extract 
//certain cables between two directly connected computers, and place them between any 
//pair of disconnected computers to make them directly connected. 
//
// Return the minimum number of times you need to do this in order to make all 
//the computers connected. If it is not possible, return -1. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, connections = [[0,1],[0,2],[1,2]]
//Output: 1
//Explanation: Remove cable between computer 1 and 2 and place between 
//computers 1 and 3.
// 
//
// Example 2: 
//
// 
//Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
//Output: -1
//Explanation: There are not enough cables.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁵ 
// 1 <= connections.length <= min(n * (n - 1) / 2, 10⁵) 
// connections[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// There are no repeated connections. 
// No two computers are connected by more than one cable. 
// 
// Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 19
//63 👎 31


package leetcode.editor.en;

// 2022-03-30 21:13:02

public class P1319NumberOfOperationsToMakeNetworkConnected {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int makeConnected(int n, int[][] connections) {
            int[] parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            int redundantCount = 0;
            for (int[] connection : connections) {
                int aRoot = findRoot(parents, connection[0]);
                int bRoot = findRoot(parents, connection[1]);
                if (aRoot == bRoot) {
                    redundantCount++;
                } else if (aRoot < bRoot) {
                    parents[bRoot] = aRoot;
                } else {
                    parents[aRoot] = bRoot;
                }
            }
            int disjointCount = 0; // root count
            for (int index = 0; index < n; index++) {
                if (index == parents[index]) {
                    disjointCount++;
                }
            }
            int minimumRequired = disjointCount - 1;
            return redundantCount < minimumRequired ? -1 : minimumRequired;
        }

        private int findRoot(int[] parents, int index) {
            while (index != parents[index]) {
                index = parents[index];
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1319NumberOfOperationsToMakeNetworkConnected().new Solution();
        
    } 
}