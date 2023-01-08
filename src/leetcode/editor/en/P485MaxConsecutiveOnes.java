//Given a binary array nums, return the maximum number of consecutive 1's in 
//the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,0,1,1,1]
//Output: 3
//Explanation: The first two digits or the last three digits are consecutive 1s.
// The maximum number of consecutive 1s is 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,0,1,1,0,1]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] is either 0 or 1. 
// 
//
// Related Topics Array 👍 3824 👎 418


package leetcode.editor.en;

// 2023-01-08 15:39:09

public class P485MaxConsecutiveOnes {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int res = 0;
            int count = 0;
            for (int n : nums) {
                if (n == 1) {
                    count++;
                } else {
                    res = Math.max(res, count);
                    count = 0;
                }
            }
            res = Math.max(res, count);
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P485MaxConsecutiveOnes().new Solution();
        
    } 
}