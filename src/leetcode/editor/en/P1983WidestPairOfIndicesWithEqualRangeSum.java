//You are given two 0-indexed binary arrays nums1 and nums2. Find the widest 
//pair of indices (i, j) such that i <= j and nums1[i] + nums1[i+1] + ... + nums1[j] 
//== nums2[i] + nums2[i+1] + ... + nums2[j]. 
//
// The widest pair of indices is the pair with the largest distance between i 
//and j. The distance between a pair of indices is defined as j - i + 1. 
//
// Return the distance of the widest pair of indices. If no pair of indices 
//meets the conditions, return 0. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,1,0,1], nums2 = [0,1,1,0]
//Output: 3
//Explanation:
//If i = 1 and j = 3:
//nums1[1] + nums1[2] + nums1[3] = 1 + 0 + 1 = 2.
//nums2[1] + nums2[2] + nums2[3] = 1 + 1 + 0 = 2.
//The distance between i and j is j - i + 1 = 3 - 1 + 1 = 3.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [0,1], nums2 = [1,1]
//Output: 1
//Explanation:
//If i = 1 and j = 1:
//nums1[1] = 1.
//nums2[1] = 1.
//The distance between i and j is j - i + 1 = 1 - 1 + 1 = 1.
// 
//
// Example 3: 
//
// 
//Input: nums1 = [0], nums2 = [1]
//Output: 0
//Explanation:
//There are no pairs of indices that meet the requirements.
// 
//
// 
// Constraints: 
//
// 
// n == nums1.length == nums2.length 
// 1 <= n <= 10⁵ 
// nums1[i] is either 0 or 1. 
// nums2[i] is either 0 or 1. 
// 
// Related Topics Array Hash Table Prefix Sum 👍 40 👎 0


package leetcode.editor.en;

// 2022-03-11 16:04:50

import java.util.HashMap;
import java.util.Map;

public class P1983WidestPairOfIndicesWithEqualRangeSum {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int widestPairOfIndices(int[] nums1, int[] nums2) {
            
            int widest = 0;
            
            // { prefixSum_1 - prefixSum_2 : first occurrence index }
            Map<Integer, Integer> prefixSumDiffMap = new HashMap<>();
            prefixSumDiffMap.put(0, -1);

            int prefixSum1 = 0, prefixSum2 = 0;
            for (int i = 0; i < nums1.length; i++) {
                prefixSum1 += nums1[i];
                prefixSum2 += nums2[i];
                int diff = prefixSum1 - prefixSum2;
                prefixSumDiffMap.putIfAbsent(diff, i);
                widest = Math.max(widest, i - prefixSumDiffMap.get(diff));
            }
            
            return widest;
            
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1983WidestPairOfIndicesWithEqualRangeSum().new Solution();
        
    } 
}