//You are given a 0-indexed array of integers nums of length n. You are 
//initially positioned at nums[0]. 
//
// Each element nums[i] represents the maximum length of a forward jump from 
//index i. In other words, if you are at nums[i], you can jump to any nums[i + j] 
//where: 
//
// 
// 0 <= j <= nums[i] and 
// i + j < n 
// 
//
// Return the minimum number of jumps to reach nums[n - 1]. The test cases are 
//generated such that you can reach nums[n - 1]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 
//step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,0,1,4]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// It's guaranteed that you can reach nums[n - 1]. 
// 
//
// Related Topics Array Dynamic Programming Greedy 👍 12548 👎 440


package leetcode.editor.en;

// 2023-07-01 14:45:34

public class P45JumpGameIi {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            int[] minSteps = new int[n];
            for (int i = n-2; i >= 0; i--) {
                int localMinSteps = n;
                for (int s = 1; s <= nums[i] && i + s < n; s++) {
                    localMinSteps = Math.min(localMinSteps, minSteps[i + s]);
                }
                minSteps[i] = 1 + localMinSteps;
            }
            return minSteps[0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P45JumpGameIi().new Solution();
        
    } 
}