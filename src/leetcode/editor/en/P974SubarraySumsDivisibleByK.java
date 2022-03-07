//Given an integer array nums and an integer k, return the number of non-empty 
//subarrays that have a sum divisible by k. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [4,5,0,-2,-3,1], k = 5
//Output: 7
//Explanation: There are 7 subarrays with a sum divisible by k = 5:
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// Example 2: 
//
// 
//Input: nums = [5], k = 9
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 2 <= k <= 10⁴ 
// 
// Related Topics Array Hash Table Prefix Sum 👍 2597 👎 131


package leetcode.editor.en;

// 2022-03-04 08:58:37

import java.util.HashMap;
import java.util.Map;

public class P974SubarraySumsDivisibleByK {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            int res = 0;
            // { prefixSumMod : count }
            Map<Integer, Integer> prefixSumModMap = new HashMap<>();
            prefixSumModMap.put(0, 1);

            int prefixSumMod = 0;
            for (int n : nums) {
                prefixSumMod = (prefixSumMod + n) % k; // [-k, k]

//                // Analysis
//                // target: (a - target) % k == 0
//                // 0. target == a
//                // 1. target == a + k
//                // 2. target == a - k
//                res += prefixSumModMap.getOrDefault(prefixSumMod, 0);
//                res += prefixSumModMap.getOrDefault(prefixSumMod + k, 0);
//                res += prefixSumModMap.getOrDefault(prefixSumMod - k, 0);

                if (prefixSumMod < 0) {
                    prefixSumMod += k;
                }
                res += prefixSumModMap.getOrDefault(prefixSumMod, 0);

                prefixSumModMap.put(prefixSumMod, prefixSumModMap.getOrDefault(prefixSumMod, 0) + 1);
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P974SubarraySumsDivisibleByK().new Solution();
        
    } 
}