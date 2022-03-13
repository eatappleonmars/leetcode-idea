//Given a collection of candidate numbers (candidates) and a target number (
//target), find all unique combinations in candidates where the candidate numbers sum 
//to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: The solution set must not contain duplicate combinations. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics Array Backtracking 👍 4818 👎 126


package leetcode.editor.en;

// 2022-03-12 16:40:16

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40CombinationSumIi {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            Arrays.sort(candidates);

            List<Integer> curr = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();

            helper(0, candidates, target, curr, res);

            return res;
        }

        private void helper(int start, int[] candidates, int target, List<Integer> curr, List<List<Integer>> res) {

            if (target == 0) {
                res.add(new ArrayList<>(curr));
                return;
            }

            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                // Need deduplication. Example: [1, 1, 3], target = 4
                // Solution: for repeated candidate, only allow to start from its first and explore all combinations
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                curr.add(candidates[i]);
                helper(i + 1, candidates, target - candidates[i], curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P40CombinationSumIi().new Solution();
        
    } 
}