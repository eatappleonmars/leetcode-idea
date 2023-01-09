//Given a binary array nums and an integer k, return the maximum number of 
//consecutive 1's in the array if you can flip at most k 0's. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//Output: 6
//Explanation: [1,1,1,0,0,1,1,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined. 
//
// Example 2: 
//
// 
//Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
//Output: 10
//Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] is either 0 or 1. 
// 0 <= k <= nums.length 
// 
//
// Related Topics Array Binary Search Sliding Window Prefix Sum 👍 5750 👎 67


package leetcode.editor.en;

// 2023-01-09 09:54:07

import java.util.LinkedList;
import java.util.Queue;

public class P1004MaxConsecutiveOnesIii {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] nums, int k) {
            if (nums.length <= k) {
                return nums.length;
            }
            int res = 0;
            int lt = 0;
            for (int rt = 0; rt < nums.length; rt++) {
                if (nums[rt] == 0) {
                    k--;
                }
                while (k < 0) {
                    if (nums[lt] == 0) {
                        k++;
                    }
                    lt++;
                }
                res = Math.max(res, rt - lt + 1);
            }
            return res;
        }

        // Sliding window will stretch to the max size.
        // The left boundary will be forced to move along with the right boundary when the max size has been reached.
        // The max size is automatically maintain because the size does not shrink once reaching the max size.
        private int cleverSolution(int[] nums, int k) {
            int i = 0, j;
            for (j = 0; j < nums.length; ++j) {
                if (nums[j] == 0) {
                    k--;
                }
                if (k < 0) {
                    if (nums[i] == 0) {
                        k++;
                    }
                    i++;
                }
            }
            return j - i;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1004MaxConsecutiveOnesIii().new Solution();
        
    } 
}