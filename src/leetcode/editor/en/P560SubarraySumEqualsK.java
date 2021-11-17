//Given an array of integers nums and an integer k, return the total number of 
//continuous subarrays whose prefixSum equals to k. 
//
// 
// Example 1: 
// Input: nums = [1,1,1], k = 2
//Output: 2
// Example 2: 
// Input: nums = [1,2,3], k = 3
//Output: 2
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics Array Hash Table Prefix prefixSum 👍 9775 👎 325


package leetcode.editor.en;

// 2021-11-16 20:47:14
// Good explanation for reference: https://youtu.be/aYfwus5T3Bs

import java.util.HashMap;
import java.util.Map;

public class P560SubarraySumEqualsK {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int result = 0;

            // Mapping: {seen prefixSum : count}
            Map<Integer, Integer> prefixSumToCountMap = new HashMap<>();

            // We look for (prefix_j - prefix_i == k)
            // What if (prefix_j == k)?
            // We need a sentinel to deal with this edge case
            prefixSumToCountMap.put(0, 1); // handle case when prefixSum_j == k

            // Definition of prefixSum: sum of num[0 : index]
            int prefixSum_i;
            int prefixSum_j = 0;
            for (int j = 0; j < nums.length; j++) {
                prefixSum_j += nums[j]; // calculate prefixSum to the current index j
                prefixSum_i = prefixSum_j - k; // because we look for (prefix_j - prefix_i == k)

                // Get the count of prefix_i, meaning there are such n pair of subArray [i:j] that sums up to k
                result += prefixSumToCountMap.getOrDefault(prefixSum_i, 0);
                // Update map
                prefixSumToCountMap.put(prefixSum_j, prefixSumToCountMap.getOrDefault(prefixSum_j, 0) + 1);
            }
            
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P560SubarraySumEqualsK().new Solution();

        final int[] nums1 = {1, 1, 1};
        final int k1 = 2;
        System.out.println(sol.subarraySum(nums1, k1));

        final int[] nums2 = {1, 1, 1};
        final int k2 = 2;
        System.out.println(sol.subarraySum(nums2, k2));

        final int[] nums3 = {1, 1, 1};
        final int k3 = 1;
        System.out.println(sol.subarraySum(nums3, k3));
    } 
}