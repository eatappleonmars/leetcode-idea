//Given an unsorted array of integers nums, return the length of the longest 
//consecutive elements sequence. 
//
// You must write an algorithm that runs in O(n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
//Therefore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics Array Hash Table Union Find 👍 8748 👎 386


package leetcode.editor.en;

// 2022-03-25 09:57:46

import java.util.HashSet;
import java.util.Set;

public class P128LongestConsecutiveSequence {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                set.add(n);
            }
            int res = 0;
            for (int n : set) {
                if (set.contains(n - 1)) {
                    continue; // n must have been processed
                }
                int count = 1; // itself
                int m = n + 1;
                while (set.contains(m)) {
                    count++;
                    m++;
                }
                res = Math.max(res, count);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P128LongestConsecutiveSequence().new Solution();
        
    } 
}