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

public class P525ContiguousArray {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {

            int[] prefixSum = new int[nums.length + 1];
            for (int i = 1; i < prefixSum.length; i++) {
                prefixSum[i] = prefixSum[i-1] + nums[i-1];
            }

            int windowSize = nums.length % 2 == 0 ? nums.length : nums.length - 1;
            while (windowSize >= 2) {
                for (int i = 1, j = i + windowSize - 1; j < prefixSum.length; i++, j++) {
                    int windowSum = prefixSum[j] - prefixSum[i-1];
                    if (windowSum << 1 ==  windowSize) {
                        return windowSize;
                    }
                }
                windowSize -= 2;
            }
            return 0;
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