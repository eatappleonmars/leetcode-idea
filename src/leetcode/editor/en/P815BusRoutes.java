//You are given an array routes representing bus routes where routes[i] is a 
//bus route that the iᵗʰ bus repeats forever. 
//
// 
// For example, if routes[0] = [1, 5, 7], this means that the 0ᵗʰ bus travels 
//in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever. 
// 
//
// You will start at the bus stop source (You are not on any bus initially), 
//and you want to go to the bus stop target. You can travel between bus stops by 
//buses only. 
//
// Return the least number of buses you must take to travel from source to 
//target. Return -1 if it is not possible. 
//
// 
// Example 1: 
//
// 
//Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//Output: 2
//Explanation: The best strategy is take the first bus to the bus stop 7, then 
//take the second bus to the bus stop 6.
// 
//
// Example 2: 
//
// 
//Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target =
// 12
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= routes.length <= 500. 
// 1 <= routes[i].length <= 10⁵ 
// All the values of routes[i] are unique. 
// sum(routes[i].length) <= 10⁵ 
// 0 <= routes[i][j] < 10⁶ 
// 0 <= source, target < 10⁶ 
// 
// Related Topics Array Hash Table Breadth-First Search 👍 1918 👎 49


package leetcode.editor.en;

// 2022-03-28 09:13:38

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class P815BusRoutes {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int res = Integer.MAX_VALUE;

        public int numBusesToDestination(int[][] routes, int source, int target) {

            if (source == target) {
                return 0;
            }

            Map<Integer, Set<Integer>> map = new HashMap<>(); // { stopId : busIds }

            for (int busId = 0; busId < routes.length; busId++) {
                int[] route = routes[busId];
                for (int stopId : route) {
                    Set<Integer> busIds = map.computeIfAbsent(stopId, r -> new HashSet<>());
                    busIds.add(busId);
                }
            }
            
            int res = 0;

            Queue<Integer> sourceStopIdQueue = new ArrayDeque<>();
            sourceStopIdQueue.offer(source);
            
            boolean[] visitedBusIds = new boolean[routes.length];

            while (!sourceStopIdQueue.isEmpty()) {
                res++;
                int levelSize = sourceStopIdQueue.size();
                for (int i = 0; i < levelSize; i++) {
                    int stopId = sourceStopIdQueue.poll();
                    Set<Integer> busIds = map.getOrDefault(stopId, Set.of());
                    for (int busId : busIds) {
                        if (visitedBusIds[busId]) {
                            continue;
                        }
                        visitedBusIds[busId] = true;
                        for (int nextStopId : routes[busId]) {
                            if (nextStopId == target) {
                                return res;
                            }
                            sourceStopIdQueue.offer(nextStopId);
                        }
                    }
                }
            }

            return -1;
        }

        private void dfs(Map<Integer, Set<Integer>> busStopRelationMap, int source, int target, Set<Integer> visitedBusStops, int depth) {
            if (!busStopRelationMap.containsKey(source) || visitedBusStops.contains(source)) {
                return;
            }

            visitedBusStops.add(source);
            Set<Integer> neighbors = busStopRelationMap.get(source);

            if (neighbors.contains(target)) {
                res = Math.min(res, depth);
                return;
            }

            for (int neighbor : neighbors) {
                dfs(busStopRelationMap, neighbor, target, visitedBusStops, depth + 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P815BusRoutes().new Solution();
        
    } 
}