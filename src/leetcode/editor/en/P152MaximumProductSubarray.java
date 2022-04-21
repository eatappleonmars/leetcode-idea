//Given an integer array nums, find a contiguous non-empty subarray within the 
//array that has the largest product, and return the product. 
//
// The test cases are generated so that the answer will fit in a 32-bit integer.
// 
//
// A subarray is a contiguous subsequence of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
// 
// Related Topics Array Dynamic Programming 👍 11196 👎 347


package leetcode.editor.en;

// 2022-04-21 09:43:44

public class P152MaximumProductSubarray {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int[] maxDp = new int[nums.length];
            int[] minDp = new int[nums.length];

            maxDp[0] = nums[0];
            minDp[0] = nums[0];

            int res = nums[0];

            for (int i = 1; i < nums.length; i++) {
                int p1 = nums[i] * maxDp[i-1];
                int p2 = nums[i] * minDp[i-1];

                maxDp[i] = Math.max(nums[i], Math.max(p1, p2));
                minDp[i] = Math.min(nums[i], Math.min(p1, p2));

                res = Math.max(res, maxDp[i]);
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P152MaximumProductSubarray().new Solution();
        
    } 
}