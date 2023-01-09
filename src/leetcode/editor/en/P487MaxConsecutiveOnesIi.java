//Related Topics Array Dynamic Programming Sliding Window 👍 1332 👎 22


package leetcode.editor.en;

// 2023-01-08 16:01:03

public class P487MaxConsecutiveOnesIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int res = 0;

            int prevZeroIndex = -1;

            int lt = 0;
            for (int rt = 0; rt < nums.length; rt++) {
                if (nums[rt] == 0) {
                    lt = prevZeroIndex + 1;
                    prevZeroIndex = rt;
                }
                res = Math.max(res, rt - lt + 1);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P487MaxConsecutiveOnesIi().new Solution();
        int[] nums = {1, 0, 1, 1, 0};
        System.out.println(sol.findMaxConsecutiveOnes(nums));
    } 
}