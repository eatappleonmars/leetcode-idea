//Given an integer array nums of unique elements, return all possible subsets (
//the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in 
//any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// All the numbers of nums are unique. 
// 
// Related Topics Array Backtracking Bit Manipulation 👍 9975 👎 157


package leetcode.editor.en;

// 2022-05-18 09:26:40

import java.util.ArrayList;
import java.util.List;

public class P78Subsets {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> subset = new ArrayList<>();
            helper(0, nums, subset, res);
            return res;
        }

        private void helper(int index, int[] nums, List<Integer> subset, List<List<Integer>> res) {
            if (index == nums.length) {
                res.add(new ArrayList<>(subset));
                return;
            }
            // All subsets without nums[index]
            helper(index + 1, nums, subset, res);
            // All subsets with nums[index]
            subset.add(nums[index]);
            helper(index + 1, nums, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P78Subsets().new Solution();
        
    } 
}