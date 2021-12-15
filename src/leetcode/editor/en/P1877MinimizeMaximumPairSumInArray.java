//The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the 
//largest pair sum in a list of pairs. 
//
// 
// For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum 
//would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8. 
// 
//
// Given an array nums of even length n, pair up the elements of nums into n / 2
// pairs such that: 
//
// 
// Each element of nums is in exactly one pair, and 
// The maximum pair sum is minimized. 
// 
//
// Return the minimized maximum pair sum after optimally pairing up the 
//elements. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,5,2,3]
//Output: 7
//Explanation: The elements can be paired up into pairs (3,3) and (5,2).
//The maximum pair sum is max(3+3, 5+2) = max(6, 7) = 7.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,5,4,2,4,6]
//Output: 8
//Explanation: The elements can be paired up into pairs (3,5), (4,4), and (6,2).
//
//The maximum pair sum is max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 2 <= n <= 10⁵ 
// n is even. 
// 1 <= nums[i] <= 10⁵ 
// Related Topics Array Two Pointers Greedy Sorting 👍 440 👎 106


package leetcode.editor.en;

// 2021-12-14 09:41:23

import java.util.Arrays;

public class P1877MinimizeMaximumPairSumInArray {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPairSum(int[] nums) {
            Arrays.sort(nums);

            // Given array [a, b, c, d], there are three possible combination of pairs:
            // 1. ab, cd -- only care about cd
            // 2. ac, bd -- only care about bd
            // 3. ad, bc -- need to consider both ad and bc
            // Comparisons:
            // 1. cd must be the maximum of all pairs, skip option 1
            // 2. bd >= bc, skip option 2
            // 3. minimum pair must be either ad or bc


            int res = 0;
            int i = 0, j = nums.length - 1;
            while (i < j) {
                res = Math.max(res, nums[i] + nums[j]);
                i++;
                j--;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1877MinimizeMaximumPairSumInArray().new Solution();
        
    } 
}