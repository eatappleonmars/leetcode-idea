//Given an integer array nums, return an array answer such that answer[i] is 
//equal to the product of all the elements of nums except nums[i]. 
//
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
//
// You must write an algorithm that runs in O(n) time and without using the 
//division operation. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
// Example 2: 
// Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]
// 
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
// 
//
// 
// Follow up: Can you solve the problem in O(1) extra space complexity? (The 
//output array does not count as extra space for space complexity analysis.) 
// Related Topics Array Prefix Sum 👍 9617 👎 631


package leetcode.editor.en;

// 2021-11-22 13:02:40

public class P238ProductOfArrayExceptSelf {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            int[] result = new int[len];

            result[0] = 1;
            for (int i = 1; i < len; i++) {
                result[i] = result[i - 1] * nums[i - 1];
            }
            int rtProduct = 1;
            for (int i = len - 2; i >= 0; i--) {
                rtProduct *= nums[i + 1];
                result[i] *= rtProduct;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P238ProductOfArrayExceptSelf().new Solution();
        
    } 
}