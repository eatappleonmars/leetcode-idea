//Given a string s, find the length of the longest substring without repeating 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 👍 23357 👎 1052


package leetcode.editor.en;

// 2022-05-04 10:05:20

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P3LongestSubstringWithoutRepeatingCharacters {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            return sol1(s);
//            return sol2(s);
        }

        // Sliding window
        private int sol1(String s) {
            int res = 0;
            Set<Character> seen = new HashSet<>();
            int i = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!seen.contains(c)) {
                    seen.add(c);
                } else {
                    res = Math.max(res, j - i);
                    while (s.charAt(i) != c) {
                        seen.remove(s.charAt(i));
                        i++;
                    }
                    i++;
                }
            }
            res = Math.max(res, s.length() - i);
            return res;
        }

        // HashMap
        private int sol2(String s) {

            int res = 0;
            Map<Character, Integer> lastSeen = new HashMap<>();

            // [lt, rt]
            for (int lt = 0, rt = 0; rt < s.length(); rt++) {
                char c = s.charAt(rt);
                if (!lastSeen.containsKey(c) || lastSeen.get(c) < lt) {
                    res = Math.max(res, rt - lt + 1);
                } else {
                    lt = lastSeen.get(c) + 1;
                }
                lastSeen.put(c, rt);
            }

            return res;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        
    } 
}