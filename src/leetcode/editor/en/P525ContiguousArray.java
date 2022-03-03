//Given a binary array nums, return the maximum length of a contiguous subarray 
//with an equal number of 0 and 1. 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,1]
//Output: 2
//Explanation: [0, 1] is the longest contiguous subarray with an equal number 
//of 0 and 1.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0]
//Output: 2
//Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal 
//number of 0 and 1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] is either 0 or 1. 
// 
// Related Topics Array Hash Table Prefix Sum 👍 5107 👎 218


package leetcode.editor.en;

// 2022-03-02 21:37:16

import java.util.HashMap;
import java.util.Map;

public class P525ContiguousArray {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {

            int res = 0;

            // { prefixSum : index of first appearance }
            Map<Integer, Integer> prefixMap = new HashMap<>();
            prefixMap.put(0, -1);

            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count += nums[i] == 0 ? -1 : 1;
                if (!prefixMap.containsKey(count)) {
                    prefixMap.put(count, i);
                } else {
                    res = Math.max(res, i - prefixMap.get(count));
                }
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P525ContiguousArray().new Solution();
        
    } 
}