//Given two strings s and p, return an array of all the start indices of p's 
//anagrams in s. You may return the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s and p consist of lowercase English letters. 
// 
// Related Topics Hash Table String Sliding Window 👍 7385 👎 252


package leetcode.editor.en;

// 2022-05-04 20:29:03

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P438FindAllAnagramsInAString {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {

            List<Integer> res = new ArrayList<>();

            if (s.length() < p.length()) {
                return res;
            }

            int[] charCounts = new int[26];
            for (char c : p.toCharArray()) {
                charCounts[c-'a']++;
            }

            int diff = p.length(); // difference between window and p

            // Fix-sized sliding window
            for (int lt = 0, rt = 0; rt < s.length(); rt++) {
                // Increment window right by one
                int rtCharIndex = s.charAt(rt) - 'a';
                charCounts[rtCharIndex]--;
                if (charCounts[rtCharIndex] >= 0) {
                    diff--;
                }
                // No further action before window reaches full size
                if (rt - lt + 1 == p.length()) {
                    if (diff == 0) {
                        res.add(lt);
                    }
                    // Increment window left by one
                    int ltCharIndex = s.charAt(lt) - 'a';
                    charCounts[ltCharIndex]++;
                    if (charCounts[ltCharIndex] > 0) {
                        diff++;
                    }
                    lt++;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P438FindAllAnagramsInAString().new Solution();
        
    } 
}