//Given an integer array nums, find the contiguous subarray (containing at 
//least one number) which has the largest sum and return its sum. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another 
//solution using the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming 👍 19992 👎 973


package leetcode.editor.en;

// 2022-04-21 09:26:44

public class P53MaximumSubarray {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {

            int res = nums[0];

            int[] dp = new int[nums.length];
            dp[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                dp[i] = nums[i] + Math.max(dp[i - 1], 0);
                res = Math.max(res, dp[i]);
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P53MaximumSubarray().new Solution();
        
    } 
}