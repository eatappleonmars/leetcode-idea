//You are given an integer array nums and an integer x. In one operation, you 
//can either remove the leftmost or the rightmost element from the array nums and 
//subtract its value from x. Note that this modifies the array for future 
//operations. 
//
// Return the minimum number of operations to reduce x to exactly 0 if it is 
//possible, otherwise, return -1. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,4,2,3], x = 5
//Output: 2
//Explanation: The optimal solution is to remove the last two elements to 
//reduce x to zero.
// 
//
// Example 2: 
//
// 
//Input: nums = [5,6,7,8,9], x = 4
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: nums = [3,2,20,1,1,3], x = 10
//Output: 5
//Explanation: The optimal solution is to remove the last three elements and 
//the first two elements (5 operations in total) to reduce x to zero.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 1 <= x <= 10⁹ 
// 
// Related Topics Array Hash Table Binary Search Sliding Window Prefix Sum 👍 14
//94 👎 27


package leetcode.editor.en;

// 2022-03-08 09:12:10

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1658MinimumOperationsToReduceXToZero {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int x) {
            // This problem is equivalent to finding the longest subArray with target sum
            int target = Arrays.stream(nums).sum() - x;
            if (target == 0) {
                return nums.length;
            }

            int maxSubArrayLen = -1;

            int prefixSum = 0;
            Map<Integer, Integer> prefixSumMap = new HashMap<>(); // { prefixSum : index }
            prefixSumMap.put(0, -1);

            for (int i = 0; i < nums.length; i++) {
                prefixSum += nums[i];
                if (prefixSumMap.containsKey(prefixSum - target)) {
                    maxSubArrayLen = Math.max(maxSubArrayLen, i - prefixSumMap.get(prefixSum - target));
                }
                prefixSumMap.put(prefixSum, i);
            }

            return maxSubArrayLen == -1 ? -1 : nums.length - maxSubArrayLen;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1658MinimumOperationsToReduceXToZero().new Solution();
        
    } 
}