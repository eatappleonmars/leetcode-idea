//Given a string s and an integer k, return the length of the longest substring 
//of s that contains at most k distinct characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "eceba", k = 2
//Output: 3
//Explanation: The substring is "ece" with length 3. 
//
// Example 2: 
//
// 
//Input: s = "aa", k = 1
//Output: 2
//Explanation: The substring is "aa" with length 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 0 <= k <= 50 
// 
//
// Related Topics Hash Table String Sliding Window 👍 2551 👎 76


package leetcode.editor.en;

// 2023-01-08 12:52:37

import java.util.HashMap;
import java.util.Map;

public class P340LongestSubstringWithAtMostKDistinctCharacters {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (k == 0) {
                return 0;
            }
            int res = 1;
            // Sliding window boundaries [lt, rt)
            int lt = 0;
            // Count of distinct letters within the sliding window
            int distinct = 0;
            // Count of letters in within the sliding window
            int[] counts = new int[256];

            // Expand sliding window's right boundary by 1 in each iteration
            for (int rt = 0; rt < s.length(); rt++) {
                char c = s.charAt(rt);
                counts[c]++;
                // Increment distinct count if this is a new char within the window
                if (counts[c] == 1) {
                    distinct++;
                }
                // Shrink sliding window from the left boundary if there are too many distinct chars
                while (distinct > k) {
                    char ltChar = s.charAt(lt);
                    counts[ltChar]--;
                    if (counts[ltChar] == 0) {
                        distinct--;
                    }
                    lt++;
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
        Solution sol = new P340LongestSubstringWithAtMostKDistinctCharacters().new Solution();
        
    } 
}