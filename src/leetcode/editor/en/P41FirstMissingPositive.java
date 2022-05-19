//Given an unsorted integer array nums, return the smallest missing positive 
//integer. 
//
// You must implement an algorithm that runs in O(n) time and uses constant 
//extra space. 
//
// 
// Example 1: 
// Input: nums = [1,2,0]
//Output: 3
// Example 2: 
// Input: nums = [3,4,-1,1]
//Output: 2
// Example 3: 
// Input: nums = [7,8,9,11,12]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
// Related Topics Array Hash Table 👍 9577 👎 1343


package leetcode.editor.en;

// 2022-05-19 09:15:22

public class P41FirstMissingPositive {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {

            // Core hints:
            // 1. Target value range: [1, n + 1]
            // 2. Convert between value and index.
            //    Example: value = 3
            //      If 3 exists, mark the 3rd element (index = 2) in array as negative
            //      So if we see the 3rd element (index = 2) is negative later, we know 3 exists

            final int n = nums.length;

            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0) {
                    nums[i] = n + 1; // not a good idea to use 0 because sign info could be lost
                }
            }

            // Use negative sign to indicate value in range of [1, n] exists, with converting value to its index
            // Example: [3, 1, -1, 4] -> [3, 1, 5, 4] with above step
            //   Given i = 0, value = nums[0] = 3
            //     Mark the element at index = (3-1) = 2 as negative,  [ 3, 1, -5,  4]
            //   Given i = 1, value = nums[1] = 1,        index = 0,   [-3, 1, -5,  4]
            //   Given i = 2, value = nums[2] = |-5| = 5,,index > 4,   [-3, 1, -5,  4]
            //   Given i = 3, value = nums[3] = |-4| = 4, index = 3,   [-3, 1, -5, -4]
            for (int value : nums) {
                value = Math.abs(value);
                int index = value - 1;
                if (index < n && nums[index] > 0) { // no action if already negative
                    nums[index] = -nums[index];
                }
            }

            // Iterate starting from the smallest positive 1 to n
            // Example:  [-3, 1, -5, -4]
            //   Value at index = 1 > 0, so result = index + 1 = 2
            for (int value = 1; value <= n; value++) {
                int index = value - 1;
                if (nums[index] > 0) {
                    return value;
                }
            }

            return n + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P41FirstMissingPositive().new Solution();
        
    } 
}