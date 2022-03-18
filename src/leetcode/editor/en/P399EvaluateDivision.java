//You are given an array of variable pairs equations and an array of real 
//numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai 
/// Bi = values[i]. Each Ai or Bi is a string that represents a single variable. 
//
// You are also given some queries, where queries[j] = [Cj, Dj] represents the 
//jᵗʰ query where you must find the answer for Cj / Dj = ?. 
//
// Return the answers to all queries. If a single answer cannot be determined, 
//return -1.0. 
//
// Note: The input is always valid. You may assume that evaluating the queries 
//will not result in division by zero and that there is no contradiction. 
//
// 
// Example 1: 
//
// 
//Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a",
//"c"],["b","a"],["a","e"],["a","a"],["x","x"]]
//Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
//Explanation: 
//Given: a / b = 2.0, b / c = 3.0
//queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
// 
//
// Example 2: 
//
// 
//Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], 
//queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//Output: [3.75000,0.40000,5.00000,0.20000]
// 
//
// Example 3: 
//
// 
//Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"]
//,["a","c"],["x","y"]]
//Output: [0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
// Constraints: 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj consist of lower case English letters and digits. 
// 
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Graph Shortest Path 👍 4774 👎 403


package leetcode.editor.en;

// 2022-03-17 21:04:05

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P399EvaluateDivision {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

            Map<String, Map<String, Double>> graph = buildGraph(equations, values);

            double[] res = new double[queries.size()];

            for (int i = 0; i < queries.size(); i++) {
                List<String> query = queries.get(i);
                res[i] = dfs(query.get(0), query.get(1), graph, new HashSet<>());
            }

            return res;
        }

        // [x, y] -> ? transforms to [x, z] * [z, y] -> ?
        private double dfs(String x, String y, Map<String, Map<String, Double>> graph, Set<String> visited) {

            if (!graph.containsKey(x) || !graph.containsKey(y)) {
                return -1.0;
            }

            if (x.equals(y)) {
                return 1.0;
            }

            if (graph.get(x).containsKey(y)) {
                return graph.get(x).get(y);
            }

            visited.add(x);

            for (Map.Entry<String, Double> entry : graph.get(x).entrySet()) {
                String z = entry.getKey();
                if (visited.contains(z)) {
                    continue;
                }

                double res = entry.getValue() * dfs(z, y, graph, visited);
                if (res > 0) {
                    return res;
                }
            }

            visited.remove(x);

            return -1.0;
        }

        Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {

            Map<String, Map<String, Double>> graph = new HashMap<>();

            for (int i = 0; i < equations.size(); i++) {
                List<String> equation = equations.get(i);
                // [x, y] -> values[i]
                String x = equation.get(0);
                String y = equation.get(1);
                double z = values[i];

                graph.putIfAbsent(x, new HashMap<>());
                graph.putIfAbsent(y, new HashMap<>());

                graph.get(x).put(y, z); // [x, y] -> z
                graph.get(y).put(x, 1.0 / z); // [y, x] -> 1 / z
            }

            return graph;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P399EvaluateDivision().new Solution();
        
    } 
}