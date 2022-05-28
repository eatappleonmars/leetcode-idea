//Given an array of strings words, find the longest string in words such that 
//every prefix of it is also in words. 
//
// 
// For example, let words = ["a", "app", "ap"]. The string "app" has prefixes 
//"ap" and "a", all of which are in words. 
// 
//
// Return the string described above. If there is more than one string with the 
//same length, return the lexicographically smallest one, and if no string exists,
// return "". 
//
// 
// Example 1: 
//
// 
//Input: words = ["k","ki","kir","kira", "kiran"]
//Output: "kiran"
//Explanation: "kiran" has prefixes "kira", "kir", "ki", and "k", and all of 
//them appear in words.
// 
//
// Example 2: 
//
// 
//Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//Output: "apple"
//Explanation: Both "apple" and "apply" have all their prefixes in words.
//However, "apple" is lexicographically smaller, so we return that.
// 
//
// Example 3: 
//
// 
//Input: words = ["abc", "bc", "ab", "qwe"]
//Output: ""
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 10⁵ 
// 1 <= words[i].length <= 10⁵ 
// 1 <= sum(words[i].length) <= 10⁵ 
// Related Topics Depth-First Search Trie 👍 110 👎 3


package leetcode.editor.en;

// 2022-05-28 09:24:32

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1858LongestWordWithAllPrefixes {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestWord(String[] words) {

            Arrays.sort(words, (w1, w2) -> {
                if (w1.length() != w2.length()) {
                    return w1.length() - w2.length();
                }
                return w1.compareTo(w2);
            });

            Map<String, Integer> map = new HashMap<>();
            String res = "";

            for (String word : words) {
                if (map.containsKey(word)) { // skip duplicate word
                    continue;
                }
                String prefix = word.substring(0, word.length() - 1);
                int prefixCount = map.getOrDefault(prefix, 0);
                if (prefixCount == prefix.length() && word.length() > res.length()) {
                    res = word;
                    if (res.length() == words[words.length - 1].length()) {
                        break;
                    }
                }
                map.put(word, prefixCount + 1);
            }

            return res;
        }

        private String takeLongestWord(String s, String candidate) {
            if (s == null) {
                return candidate;
            }
            return s.compareTo(candidate) < 0 ? s : candidate;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1858LongestWordWithAllPrefixes().new Solution();
        
    } 
}