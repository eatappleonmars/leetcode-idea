//Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find 
//all possible paths from node 0 to node n - 1 and return them in any order. 
//
// The graph is given as follows: graph[i] is a list of all nodes you can visit 
//from node i (i.e., there is a directed edge from node i to node graph[i][j]). 
//
// 
// Example 1: 
//
// 
//Input: graph = [[1,2],[3],[3],[]]
//Output: [[0,1,3],[0,2,3]]
//Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
// 
//
// Example 2: 
//
// 
//Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
//Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
// 
//
// 
// Constraints: 
//
// 
// n == graph.length 
// 2 <= n <= 15 
// 0 <= graph[i][j] < n 
// graph[i][j] != i (i.e., there will be no self-loops). 
// All the elements of graph[i] are unique. 
// The input graph is guaranteed to be a DAG. 
// 
// Related Topics Backtracking Depth-First Search Breadth-First Search Graph 👍 
//4149 👎 117


package leetcode.editor.en;

// 2022-05-20 09:25:43

import java.util.ArrayList;
import java.util.List;

public class P797AllPathsFromSourceToTarget {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(graph, 0, new ArrayList<>(), res);
            return res;
        }

        private void dfs(int[][] graph, int index, List<Integer> path, List<List<Integer>> res) {
            if (index == graph.length - 1) {
                path.add(index);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
            path.add(index);
            int[] neighbors = graph[index];
            for (int neighbor : neighbors) {
                dfs(graph, neighbor, path, res);
            }
            path.remove(path.size() - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P797AllPathsFromSourceToTarget().new Solution();
        
    } 
}