//Find all valid combinations of k numbers that sum up to n such that the 
//following conditions are true: 
//
// 
// Only numbers 1 through 9 are used. 
// Each number is used at most once. 
// 
//
// Return a list of all possible valid combinations. The list must not contain 
//the same combination twice, and the combinations may be returned in any order. 
//
// 
// Example 1: 
//
// 
//Input: k = 3, n = 7
//Output: [[1,2,4]]
//Explanation:
//1 + 2 + 4 = 7
//There are no other valid combinations. 
//
// Example 2: 
//
// 
//Input: k = 3, n = 9
//Output: [[1,2,6],[1,3,5],[2,3,4]]
//Explanation:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//There are no other valid combinations.
// 
//
// Example 3: 
//
// 
//Input: k = 4, n = 1
//Output: []
//Explanation: There are no valid combinations.
//Using 4 different numbers in the range [1,9], the smallest sum we can get is 1
//+2+3+4 = 10 and since 10 > 1, there are no valid combination.
// 
//
// 
// Constraints: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
// Related Topics Array Backtracking 👍 2751 👎 74


package leetcode.editor.en;

// 2022-04-22 10:27:58

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P216CombinationSumIii {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {

            final int[] numbers = new int[9];
            for (int i = 0; i < 9; i++) {
                numbers[i] = i + 1;
            }

            List<List<Integer>> res = new ArrayList<>();
            dfs(0, numbers, n, 0, new int[k], res);
            return res;
        }

        private void dfs(int start, int[] numbers, int target, int index, int[] temp, List<List<Integer>> res) {

            if (index == temp.length) {
                if (target == 0) {
                    res.add(Arrays.stream(temp).boxed().collect(Collectors.toList()));
                }
                return;
            }

            for (int i = start; i < numbers.length; i++) {
                if (numbers[i] > target) {
                    break;
                }
                temp[index] = numbers[i];
                dfs(i+1, numbers, target - numbers[i], index + 1, temp, res);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P216CombinationSumIii().new Solution();
        
    } 
}