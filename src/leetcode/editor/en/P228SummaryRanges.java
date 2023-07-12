//You are given a sorted unique integer array nums. 
//
// A range [a,b] is the set of all integers from a to b (inclusive). 
//
// Return the smallest sorted list of ranges that cover all the numbers in the 
//array exactly. That is, each element of nums is covered by exactly one of the 
//ranges, and there is no integer x such that x is in one of the ranges but not in 
//nums. 
//
// Each range [a,b] in the list should be output as: 
//
// 
// "a->b" if a != b 
// "a" if a == b 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,1,2,4,5,7]
//Output: ["0->2","4->5","7"]
//Explanation: The ranges are:
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// Example 2: 
//
// 
//Input: nums = [0,2,3,4,6,8,9]
//Output: ["0","2->4","6","8->9"]
//Explanation: The ranges are:
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// All the values of nums are unique. 
// nums is sorted in ascending order. 
// 
//
// Related Topics Array 👍 3471 👎 1823


package leetcode.editor.en;

// 2023-07-11 22:16:35

import java.util.ArrayList;
import java.util.List;

public class P228SummaryRanges {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> res = new ArrayList<>();
            helper(nums, 0, res);
            return res;
        }

        private void helper(int[] nums, int lt, List<String> res) {
            if (lt == nums.length) {
                return;
            }
            int rt = lt + 1;
            while (rt < nums.length) {
                if (nums[rt] != nums[rt - 1] + 1) {
                    break;
                }
                rt++;
            }
            if (lt == rt - 1) {
                res.add(String.valueOf(nums[lt]));
            } else {
                res.add(nums[lt] + "->" + nums[rt - 1]);
            }
            helper(nums, rt, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P228SummaryRanges().new Solution();
        
    } 
}