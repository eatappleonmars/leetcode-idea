//Given a pattern and a string s, find if s follows the same pattern. 
//
// Here follow means a full match, such that there is a bijection between a 
//letter in pattern and a non-empty word in s. 
//
// 
// Example 1: 
//
// 
//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: pattern = "abba", s = "dog cat cat fish"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: pattern = "aaaa", s = "dog cat cat dog"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= pattern.length <= 300 
// pattern contains only lower-case English letters. 
// 1 <= s.length <= 3000 
// s contains only lowercase English letters and spaces ' '. 
// s does not contain any leading or trailing spaces. 
// All the words in s are separated by a single space. 
// 
//
// Related Topics Hash Table String 👍 6446 👎 778


package leetcode.editor.en;

// 2023-07-09 14:04:09

import java.util.HashSet;
import java.util.Set;

public class P290WordPattern {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] words = s.split(" ");
            if (pattern.length() != words.length) {
                return false;
            }
            String[] mapping = new String[26];
            Set<String> mapped = new HashSet<>();
            for (int i = 0; i < pattern.length(); i++) {
                int cIndex = pattern.charAt(i) - 'a';
                String word = words[i];
                if (mapping[cIndex] == null) {
                    if (mapped.contains(word)) {
                        return false;
                    }
                    mapping[cIndex] = word;
                    mapped.add(word);
                } else if (!word.equals(mapping[cIndex])) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P290WordPattern().new Solution();
        
    } 
}