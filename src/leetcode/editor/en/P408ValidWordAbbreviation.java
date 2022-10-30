//A string can be abbreviated by replacing any number of non-adjacent, non-
//empty substrings with their lengths. The lengths should not have leading zeros. 
//
// For example, a string such as "substitution" could be abbreviated as (but 
//not limited to): 
//
// 
// "s10n" ("s ubstitutio n") 
// "sub4u4" ("sub stit u tion") 
// "12" ("substitution") 
// "su3i1u2on" ("su bst i t u ti on") 
// "substitution" (no substrings replaced) 
// 
//
// The following are not valid abbreviations: 
//
// 
// "s55n" ("s ubsti tutio n", the replaced substrings are adjacent) 
// "s010n" (has leading zeros) 
// "s0ubstitution" (replaces an empty substring) 
// 
//
// Given a string word and an abbreviation abbr, return whether the string 
//matches the given abbreviation. 
//
// A substring is a contiguous non-empty sequence of characters within a string.
// 
//
// 
// Example 1: 
//
// 
//Input: word = "internationalization", abbr = "i12iz4n"
//Output: true
//Explanation: The word "internationalization" can be abbreviated as "i12iz4n" (
//"i nternational iz atio n").
// 
//
// Example 2: 
//
// 
//Input: word = "apple", abbr = "a2e"
//Output: false
//Explanation: The word "apple" cannot be abbreviated as "a2e".
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length <= 20 
// word consists of only lowercase English letters. 
// 1 <= abbr.length <= 10 
// abbr consists of lowercase English letters and digits. 
// All the integers in abbr will fit in a 32-bit integer. 
// 
//
// Related Topics Two Pointers String 👍 542 👎 1860


package leetcode.editor.en;

// 2022-10-26 20:27:20

import java.util.ArrayDeque;
import java.util.Queue;

public class P408ValidWordAbbreviation {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validWordAbbreviation(String word, String abbr) {
            int localNumber = 0;
            int i = 0;
            for (int j = 0; j < abbr.length(); j++) {
                char a = abbr.charAt(j);
                if (Character.isDigit(a)) {
                    // If a is a digit char, update localNumber
                    int digit = a - '0';
                    if (localNumber == 0 && digit == 0) {
                        // Check if abbr is invalid due to leading 0
                        return false; // invalid
                    }
                    localNumber = localNumber * 10 + (a - '0');
                } else {
                    // If a is not a digit char
                    // Fast-forward i by localNumber
                    i += localNumber;
                    localNumber = 0; // reset
                    // Check boundary & equality
                    if ( i >= word.length() || word.charAt(i) != a) {
                        return false;
                    }
                    i++;
                }
            }
            // In case of edge case: trailing digit char
            i += localNumber;
            localNumber = 0;

            return i == word.length();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P408ValidWordAbbreviation().new Solution();
        System.out.println(sol.validWordAbbreviation("internationalization", "i12iz4n"));
    } 
}