//Given an integer array nums of size n, return the minimum number of moves 
//required to make all array elements equal. 
//
// In one move, you can increment or decrement an element of the array by 1. 
//
// Test cases are designed so that the answer will fit in a 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: 2
//Explanation:
//Only two moves are needed (remember each move increments or decrements one 
//element):
//[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,10,2,9]
//Output: 16
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics Array Math Sorting 👍 1458 👎 75


package leetcode.editor.en;

// 2022-06-27 21:38:58

import java.util.Arrays;

public class P462MinimumMovesToEqualArrayElementsIi {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMoves2(int[] nums) {
            int median = findMedian(nums, 0, nums.length - 1);
            return Arrays.stream(nums).map(n -> Math.abs(n - median)).sum();
        }

        // Quick Select
        private int findMedian(int[] nums, int lt, int rt) {
            int randomIndex = lt + (int) (Math.random() * (rt - lt + 1));
            swap(nums, randomIndex, rt);

            int index = lt;
            int pivotValue = nums[rt];

            for (int i = lt; i < rt; i++) {
                if (nums[i] < pivotValue) {
                    swap(nums, i, index);
                    index++;
                }
            }

            swap(nums, index, rt);

            if (index == nums.length / 2) {
                return pivotValue;
            }
            if (index < nums.length / 2) {
                return findMedian(nums, index + 1, rt);
            } else {
                return findMedian(nums, lt, index - 1);
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
        Solution sol = new P462MinimumMovesToEqualArrayElementsIi().new Solution();
        
    } 
}