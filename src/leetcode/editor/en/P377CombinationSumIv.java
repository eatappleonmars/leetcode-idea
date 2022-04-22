//Given an array of distinct integers nums and a target integer target, return 
//the number of possible combinations that add up to target. 
//
// The test cases are generated so that the answer can fit in a 32-bit integer. 
//
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3], target = 4
//Output: 7
//Explanation:
//The possible combination ways are:
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//Note that different sequences are counted as different combinations.
// 
//
// Example 2: 
//
// 
//Input: nums = [9], target = 3
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// All the elements of nums are unique. 
// 1 <= target <= 1000 
// 
//
// 
// Follow up: What if negative numbers are allowed in the given array? How does 
//it change the problem? What limitation we need to add to the question to allow 
//negative numbers? 
// Related Topics Array Dynamic Programming 👍 3346 👎 384


package leetcode.editor.en;

// 2022-04-22 13:59:10

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P377CombinationSumIv {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int combinationSum4(int[] nums, int target) {

            Arrays.sort(nums);

            int[] dp = new int[target + 1]; // 1 <= target <= 1000

            for (int n : nums) {
                if (n <= target) {
                    dp[n] = 1;
                }
            }

            for (int t = 1; t <= target; t++) {
                helper(nums, t, dp);
            }

            return dp[target];
        }

        // Find numb
        private void helper(int[] nums, int target, int[] dp) {
            for (int n : nums) {
                if (n >= target) {
                    break;
                }
                dp[target] += dp[target - n];
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P377CombinationSumIv().new Solution();
        
    } 
}