//Given an array nums of distinct integers, return all the possible 
//permutations. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// 
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
//
// Related Topics Array Backtracking 👍 15205 👎 255


package leetcode.editor.en;

// 2023-04-03 11:38:20

import java.util.ArrayList;
import java.util.List;

public class P46Permutations {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> permutation = new ArrayList<>();
            permute(nums, 0, permutation, res);
            return res;
        }

        // Permute subarray nums[beginIndex : end)
        // To ensure permute function has consistent behavior, we need to
        // - restore nums order
        // - restore permutation list
        private void permute(int[] nums, int beginIndex, List<Integer> permutation, List<List<Integer>> res) {

            if (beginIndex == nums.length) {
                res.add(new ArrayList<>(permutation));
                return;
            }

            for (int currIndex = beginIndex; currIndex < nums.length; currIndex++) {
                // prepare
                swap(nums, beginIndex, currIndex);
                permutation.add(nums[beginIndex]);
                // permute
                permute(nums, beginIndex + 1, permutation, res);
                // restore
                permutation.remove(permutation.size() - 1);
                swap(nums, beginIndex, currIndex);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int n = nums[i];
            nums[i] = nums[j];
            nums[j] = n;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P46Permutations().new Solution();
        
    } 
}