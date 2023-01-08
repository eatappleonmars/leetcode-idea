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

            int maxLen = 1;

            final char[] sChars = s.toCharArray();
            final int len = sChars.length;
            // Sliding window boundaries [lt, rt)
            int lt = 0;
            int rt = 0;
            // Count of distinct letters within the sliding window
            int distinct = 0;
            // Count of letters in within the sliding window
            Map<Character, Integer> charCounts = new HashMap<>();
            while (true) {
                // It is IMPORTANT to keep in mind that rt should remain exclusive at this point
                // Move window's' right boundary until distinct > k
                while (rt < len) {
                    char c = sChars[rt];
                    int charCount = charCounts.getOrDefault(c, 0);
                    if (distinct < k || (distinct == k && charCount > 0)) {
                        charCounts.put(c, charCount + 1);
                        distinct += charCount == 0 ? 1 : 0;
                        rt++;
                    } else {
                        break;
                    }
                }
                // Process the current length
                maxLen = Math.max(maxLen, rt - lt);
                // Done if reaching the end of the string
                if (rt == len) {
                    break;
                }
                // Otherwise, shrink the sliding window's left boundary until distinct == k
                while (distinct >= k) {
                    char c = sChars[lt];
                    int charCount = charCounts.get(c);
                    charCounts.put(c, charCount - 1);
                    if (charCount == 1) {
                        distinct--;
                    }
                    lt++;
                }
            }
            return maxLen;
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