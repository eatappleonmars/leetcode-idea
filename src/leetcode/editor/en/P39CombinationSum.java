//Given an array of distinct integers candidates and a target integer target, 
//return a list of all unique combinations of candidates where the chosen numbers 
//sum to target. You may return the combinations in any order. 
//
// The same number may be chosen from candidates an unlimited number of times. 
//Two combinations are unique if the frequency of at least one of the chosen 
//numbers is different. 
//
// It is guaranteed that the number of unique combinations that sum up to 
//target is less than 150 combinations for the given input. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple 
//times.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
// 
//
// Example 3: 
//
// 
//Input: candidates = [2], target = 1
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// All elements of candidates are distinct. 
// 1 <= target <= 500 
// 
// Related Topics Array Backtracking 👍 10081 👎 219


package leetcode.editor.en;

// 2022-03-12 15:52:00

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P39CombinationSum {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

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

            for (int i = start; i < candidates.length && target >= candidates[start]; i++) {
                curr.add(candidates[i]);
                helper(i, candidates, target - candidates[i], curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P39CombinationSum().new Solution();
        
    } 
}