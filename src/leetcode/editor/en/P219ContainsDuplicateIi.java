//Given an integer array nums and an integer k, return true if there are two 
//distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <
//= k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1], k = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: nums = [1,0,1,1], k = 1
//Output: true
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
//
// Related Topics Array Hash Table Sliding Window 👍 5105 👎 2717


package leetcode.editor.en;

// 2023-07-09 15:04:22

import java.util.HashMap;
import java.util.Map;

public class P219ContainsDuplicateIi {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> latestSeen = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                if (!latestSeen.containsKey(n)) {
                    latestSeen.put(n, i);
                } else {
                    int latestIndex = latestSeen.get(n);
                    if (i - latestIndex <= k) {
                        return true;
                    }
                    latestSeen.replace(n, i);
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P219ContainsDuplicateIi().new Solution();
        
    } 
}