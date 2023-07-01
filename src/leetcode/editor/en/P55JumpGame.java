//You are given an integer array nums. You are initially positioned at the 
//array's first index, and each element in the array represents your maximum jump 
//length at that position. 
//
// Return true if you can reach the last index, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum 
//jump length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics Array Dynamic Programming Greedy 👍 16616 👎 876


package leetcode.editor.en;

// 2023-07-01 14:20:12

public class P55JumpGame {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int lastIndex = n - 1;

            for (int i = n-2; i >= 0; i--) {
                int maxSteps = nums[i];
                if (i + maxSteps >= lastIndex) {
                    lastIndex = i;
                }
            }

            return lastIndex == 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P55JumpGame().new Solution();
        
    } 
}