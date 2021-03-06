//Given a binary array nums and an integer goal, return the number of non-empty 
//subarrays with a sum goal. 
//
// A subarray is a contiguous part of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,1,0,1], goal = 2
//Output: 4
//Explanation: The 4 subarrays are bolded and underlined below:
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,0,0,0], goal = 0
//Output: 15
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// nums[i] is either 0 or 1. 
// 0 <= goal <= nums.length 
// Related Topics Array Hash Table Sliding Window Prefix Sum 👍 1241 👎 42


package leetcode.editor.en;

// 2022-03-03 09:29:38

import java.util.HashMap;
import java.util.Map;

public class P930BinarySubarraysWithSum {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {

            int res = 0;
            // { prefixSum : count }
            Map<Integer, Integer> prefixMap = new HashMap<>();
            prefixMap.put(0, 1);

            int prefixSum = 0;
            for (int n : nums) {
                prefixSum += n;
                res += prefixMap.getOrDefault(prefixSum - goal, 0);
                prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P930BinarySubarraysWithSum().new Solution();
        
    } 
}