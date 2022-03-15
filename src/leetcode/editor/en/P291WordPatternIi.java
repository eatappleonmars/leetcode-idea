//Given a pattern and a string s, return true if s matches the pattern. 
//
// A string s matches a pattern if there is some bijective mapping of single 
//characters to strings such that if each character in pattern is replaced by the 
//string it maps to, then the resulting string is s. A bijective mapping means that 
//no two characters map to the same string, and no character maps to two different 
//strings. 
//
// 
// Example 1: 
//
// 
//Input: pattern = "abab", s = "redblueredblue"
//Output: true
//Explanation: One possible mapping is as follows:
//'a' -> "red"
//'b' -> "blue" 
//
// Example 2: 
//
// 
//Input: pattern = "aaaa", s = "asdasdasdasd"
//Output: true
//Explanation: One possible mapping is as follows:
//'a' -> "asd"
// 
//
// Example 3: 
//
// 
//Input: pattern = "aabb", s = "xyzabcxzyabc"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= pattern.length, s.length <= 20 
// pattern and s consist of only lowercase English letters. 
// 
// Related Topics Hash Table String Backtracking 👍 704 👎 52


package leetcode.editor.en;

// 2022-03-13 22:05:23

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P291WordPatternIi {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPatternMatch(String pattern, String s) {
            Map<Character, String> mapping = new HashMap<>();
            Set<String> seen = new HashSet<>();
            return helper(0, pattern, 0, s, mapping, seen);
        }

        // Return if substring s[sIndex : sEnd) matches subpattern(pIndex, pEnd)
        private boolean helper(int pIndex, String pattern, int sIndex, String s, Map<Character, String> mapping, Set<String> seen) {

            if (pIndex == pattern.length() && sIndex == s.length()) {
                return true;
            }

            if (pIndex == pattern.length() || sIndex == s.length()) {
                return false;
            }

            char key = pattern.charAt(pIndex);

            if (mapping.containsKey(key)) {
                String prevMapped = mapping.get(key);
                return s.startsWith(prevMapped, sIndex)
                        && helper(pIndex + 1, pattern, sIndex + prevMapped.length(), s, mapping, seen);
            }

            // Try: s[sIndex : j)
            for (int i = sIndex + 1; i <= s.length(); i++) {
                String value = s.substring(sIndex, i);

                if (seen.contains(value)) {
                    continue; // invalid because a substring can only be mapped once
                }

                mapping.put(key, value);
                seen.add(value);

                if (helper(pIndex + 1, pattern, i, s, mapping, seen)) {
                    return true;
                }

                mapping.remove(key);
                seen.remove(value);
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P291WordPatternIi().new Solution();
        
    } 
}