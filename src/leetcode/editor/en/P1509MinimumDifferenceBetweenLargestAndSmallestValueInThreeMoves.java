//Given an array nums, you are allowed to choose one element of nums and change 
//it by any value in one move. 
//
// Return the minimum difference between the largest and smallest value of nums 
//after perfoming at most 3 moves. 
//
// 
// Example 1: 
//
// 
//Input: nums = [5,3,2,4]
//Output: 0
//Explanation: Change the array [5,3,2,4] to [2,2,2,2].
//The difference between the maximum and minimum is 2-2 = 0. 
//
// Example 2: 
//
// 
//Input: nums = [1,5,0,10,14]
//Output: 1
//Explanation: Change the array [1,5,0,10,14] to [1,1,0,1,1]. 
//The difference between the maximum and minimum is 1-0 = 1.
// 
//
// Example 3: 
//
// 
//Input: nums = [6,6,0,1,1,4,6]
//Output: 2
// 
//
// Example 4: 
//
// 
//Input: nums = [1,5,6,14,15]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10^5 
// -10^9 <= nums[i] <= 10^9 
// Related Topics Array Greedy Sorting 👍 838 👎 119


package leetcode.editor.en;

// 2021-11-26 15:44:21

import java.util.Arrays;

public class P1509MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDifference(int[] nums) {
            final int LEN = nums.length;
            // Only need to compare 4 paris because we have at most 3 moves
            // There are at most 4 combinations to use this quota towards max or min values
            // Index of pairs: <0, -4>, <1, -3>, <2, -2>, <3, -1>
            final int COUNT = 4;
            final int 
            if (LEN <= 4) {
                return 0;
            }
            Arrays.sort(nums);
            int result = Integer.MAX_VALUE;
            for (int i = 0, j = LEN - 4; i < COUNT; i++, j++) {
                result = Math.min(result, nums[j] - nums[i]);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1509MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves().new Solution();
        
    } 
}