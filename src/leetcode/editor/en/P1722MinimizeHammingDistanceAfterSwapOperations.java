//You are given two integer arrays, source and target, both of length n. You 
//are also given an array allowedSwaps where each allowedSwaps[i] = [ai, bi] 
//indicates that you are allowed to swap the elements at index ai and index bi (0-indexed)
// of array source. Note that you can swap elements at a specific pair of indices 
//multiple times and in any order. 
//
// The Hamming distance of two arrays of the same length, source and target, is 
//the number of positions where the elements are different. Formally, it is the 
//number of indices i for 0 <= i <= n-1 where source[i] != target[i] (0-indexed). 
//
// Return the minimum Hamming distance of source and target after performing 
//any amount of swap operations on array source. 
//
// 
// Example 1: 
//
// 
//Input: source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
//Output: 1
//Explanation: source can be transformed the following way:
//- Swap indices 0 and 1: source = [2,1,3,4]
//- Swap indices 2 and 3: source = [2,1,4,3]
//The Hamming distance of source and target is 1 as they differ in 1 position: 
//index 3.
// 
//
// Example 2: 
//
// 
//Input: source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
//Output: 2
//Explanation: There are no allowed swaps.
//The Hamming distance of source and target is 2 as they differ in 2 positions: 
//index 1 and index 2.
// 
//
// Example 3: 
//
// 
//Input: source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2]
//,[1,3],[1,4]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// n == source.length == target.length 
// 1 <= n <= 10⁵ 
// 1 <= source[i], target[i] <= 10⁵ 
// 0 <= allowedSwaps.length <= 10⁵ 
// allowedSwaps[i].length == 2 
// 0 <= ai, bi <= n - 1 
// ai != bi 
// 
// Related Topics Array Depth-First Search Union Find 👍 550 👎 16


package leetcode.editor.en;

// 2022-03-31 16:17:29

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1722MinimizeHammingDistanceAfterSwapOperations {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

            int n = source.length;
            int[] parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            
            for (int[] swap : allowedSwaps) {
                int iRoot = findRoot(parents, swap[0]);
                int jRoot = findRoot(parents, swap[1]);
                if (iRoot < jRoot) {
                    parents[jRoot] = iRoot;
                } else {
                    parents[iRoot] = jRoot;
                }
            }
            // { root : { number : count } }
            Map<Integer, Map<Integer, Integer>> availabilityMap = new HashMap<>();
            for (int index = 0; index < n; index++) {
                int root = findRoot(parents, index);
                int number = source[index];
                Map<Integer, Integer> availability = availabilityMap.computeIfAbsent(root, key -> new HashMap<>());
                availability.put(number, availability.getOrDefault(number, 0) + 1);
            }

            int res = 0;
            for (int index = 0; index < target.length; index++) {
                int root = findRoot(parents, index);
                Map<Integer, Integer> availability = availabilityMap.get(root);

                int t = target[index];
                if (availability.containsKey(t) && availability.get(t) > 0) {
                    availability.put(t, availability.get(t) - 1);
                } else {
                    res++;
                }
            }
            return res;
        }
        
        private int findRoot(int[] parents , int index) {
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
        Solution sol = new P1722MinimizeHammingDistanceAfterSwapOperations().new Solution();
        
    } 
}