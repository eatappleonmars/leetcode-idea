//Given an integer array nums and an integer k, return true if nums has a
//continuous subarray of size at least two whose elements sum up to a multiple of k, or 
//false otherwise. 
//
// An integer x is a multiple of k if there exists an integer n such that x = n 
//* k. 0 is always a multiple of k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [23,2,4,6,7], k = 6
//Output: true
//Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up 
//to 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [23,2,6,4,7], k = 6
//Output: true
//Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose 
//elements sum up to 42.
//42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
// 
//
// Example 3: 
//
// 
//Input: nums = [23,2,6,4,7], k = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= sum(nums[i]) <= 2³¹ - 1 
// 1 <= k <= 2³¹ - 1 
// 
// Related Topics Array Hash Table Math Prefix Sum 👍 1022 👎 165

// 2021-11-18 09:40:29


package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class P523ContinuousSubarraySum {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            // key: seen prefix remainder
            // value: index when remainder was seen for the first time
            Map<Integer, Integer> remainderToIndexMap = new HashMap<>();
            remainderToIndexMap.put(0, -1);

            int prefixSum = 0;
            for (int i = 0; i < nums.length; i++) {
                prefixSum += nums[i];
                int prefixSumRemainder = prefixSum % k;
                if (!remainderToIndexMap.containsKey(prefixSumRemainder)) {
                    remainderToIndexMap.put(prefixSumRemainder, i);
                } else if (i - remainderToIndexMap.get(prefixSumRemainder) > 1) {
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P523ContinuousSubarraySum().new Solution();

        final int[] nums1 = {23,2,4,6,7};
        final int k1 = 6;
        System.out.println(sol.checkSubarraySum(nums1, k1)); // true

        final int[] nums2 = {23,2,6,4,7};
        final int k2 = 6;
        System.out.println(sol.checkSubarraySum(nums2, k2)); // true

        final int[] nums3 = {23,2,6,4,7};
        final int k3 = 13;
        System.out.println(sol.checkSubarraySum(nums3, k3)); // false

        final int[] nums4 = {23,2,4,6,6};
        final int k4 = 7;
        System.out.println(sol.checkSubarraySum(nums4, k4)); // true

        final int[] nums5 = {1,0};
        final int k5 = 7;
        System.out.println(sol.checkSubarraySum(nums5, k5)); // false

        final int[] nums6 = {5,0,0,0};
        final int k6 = 3;
        System.out.println(sol.checkSubarraySum(nums6, k6)); // true
    }
}