//Given an integer array arr and an integer difference, return the length of 
//the longest subsequence in arr which is an arithmetic sequence such that the 
//difference between adjacent elements in the subsequence equals difference. 
//
// A subsequence is a sequence that can be derived from arr by deleting some or 
//no elements without changing the order of the remaining elements. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,2,3,4], difference = 1
//Output: 4
//Explanation: The longest arithmetic subsequence is [1,2,3,4]. 
//
// Example 2: 
//
// 
//Input: arr = [1,3,5,7], difference = 1
//Output: 1
//Explanation: The longest arithmetic subsequence is any single element.
// 
//
// Example 3: 
//
// 
//Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
//Output: 4
//Explanation: The longest arithmetic subsequence is [7,5,3,1].
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁵ 
// -10⁴ <= arr[i], difference <= 10⁴ 
// 
// Related Topics Array Hash Table Dynamic Programming 👍 774 👎 38


package leetcode.editor.en;

// 2021-12-13 09:27:27

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1218LongestArithmeticSubsequenceOfGivenDifference {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubsequence(int[] arr, int difference) {
            int res = 1;

            // { key : max sequence length to the current key }
            Map<Integer, Integer> dpMap = new HashMap<>();

            for (int n2 : arr) {
                // n2: current value, or target value
                // n1: previous seen value
                // Given { n2 - n1 = d }, we have { n1 = n2 - d }
                int target = n2 - difference;
                int dp = dpMap.getOrDefault(target, 0);
                // It doesn't matter whether n2 was seen previously because dp already represents the max length
                // and hence put (or overwrite) the n2 key with [dp + 1]
                dpMap.put(n2, dp + 1);
                res = Math.max(res, dp + 1);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1218LongestArithmeticSubsequenceOfGivenDifference().new Solution();
        
    } 
}