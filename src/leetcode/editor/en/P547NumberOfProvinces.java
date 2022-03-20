//There are n cities. Some of them are connected, while some are not. If city a 
//is connected directly with city b, and city b is connected directly with city c,
// then city a is connected indirectly with city c. 
//
// A province is a group of directly or indirectly connected cities and no 
//other cities outside of the group. 
//
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the 
//iᵗʰ city and the jᵗʰ city are directly connected, and isConnected[i][j] = 0 
//otherwise. 
//
// Return the total number of provinces. 
//
// 
// Example 1: 
//
// 
//Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] is 1 or 0. 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 48
//50 👎 230


package leetcode.editor.en;

// 2022-03-19 15:40:06

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P547NumberOfProvinces {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int n;

        public int findCircleNum(int[][] isConnected) {
            this.n = isConnected.length;
            // Multiple solutions
//            return dfs(isConnected);
//            return bfs(isConnected);n
            return uf(isConnected);
        }

        private int dfs(int[][] isConnected) {
            boolean[] visited = new boolean[n];
            int count = 0;
            for (int city = 0; city < n; city++) {
                if (visited[city]) {
                    continue;
                }
                dfs(city, isConnected, visited);
                count++;
            }
            return count;
        }

        private void dfs(int city, int[][] isConnected, boolean[] visited) {
            visited[city] = true;
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (isConnected[city][neighbor] == 0 || visited[neighbor]) {
                    continue;
                }
                dfs(neighbor, isConnected, visited);
            }
        }

        private int bfs(int[][] isConnected) {
            boolean[] visited = new boolean[n];
            int count = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            for (int city = 0; city < n; city++) {
                if (!visited[city]) {
                    queue.offer(city);
                    bfs(queue, isConnected, visited);
                    count++;
                }
            }
            return count;
        }

        // Visit all cities that are connected to the ones in the queue
        private void bfs(Queue<Integer> queue, int[][] isConnected, boolean[] visited) {
            while (!queue.isEmpty()) {
                int city = queue.poll();
                visited[city] = true;
                for (int neighbor = 0; neighbor < n; neighbor++) {
                    if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        private int uf(int[][] isConnected) {
            int[] parents = new int[n];
            Arrays.fill(parents, -1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isConnected[i][j] == 1 && i != j) {
                        union(parents, i, j);
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < parents.length; i++) {
                if (parents[i] == -1) {
                    count++;
                }
            }
            return count;
        }

        private void union(int[] parents, int i, int j) {
            int iParent = find(parents, i);
            int jParent = find(parents, j);
            if (iParent != jParent) {
                parents[jParent] = iParent;
            }
        }

        // Find the root node of the i-th node
        private int find(int[] parents, int i) {
            if (parents[i] == -1) {
                return i;
            }
            return find(parents, parents[i]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P547NumberOfProvinces().new Solution();
        
    } 
}