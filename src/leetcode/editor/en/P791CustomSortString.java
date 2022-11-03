//You are given two strings order and s. All the characters of order are unique 
//and were sorted in some custom order previously. 
//
// Permute the characters of s so that they match the order that order was 
//sorted. More specifically, if a character x occurs before a character y in order, 
//then x should occur before y in the permuted string. 
//
// Return any permutation of s that satisfies this property. 
//
// 
// Example 1: 
//
// 
//Input: order = "cba", s = "abcd"
//Output: "cbad"
//Explanation: 
//"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", 
//"b", and "a". 
//Since "d" does not appear in order, it can be at any position in the returned 
//string. "dcba", "cdba", "cbda" are also valid outputs.
// 
//
// Example 2: 
//
// 
//Input: order = "cbafg", s = "abcd"
//Output: "cbad"
// 
//
// 
// Constraints: 
//
// 
// 1 <= order.length <= 26 
// 1 <= s.length <= 200 
// order and s consist of lowercase English letters. 
// All the characters of order are unique. 
// 
//
// Related Topics Hash Table String Sorting 👍 2306 👎 303


package leetcode.editor.en;

// 2022-11-02 20:44:08

public class P791CustomSortString {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String customSortString(String order, String s) {
            char[] orderChars = order.toCharArray();
            char[] sChars = s.toCharArray();

            int[] counts = new int[26];
            for (char c : sChars) {
                counts[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            // Follow the 'order' and collect letters.
            for (char c : orderChars) {
                while (counts[c - 'a'] > 0) {
                    counts[c - 'a']--;
                    sb.append(c);
                }
            }
            // Collect remaining letters that are absent in the 'order' string
            for (char c = 'a'; c <= 'z'; c++) {
                int count = counts[c - 'a'];
                while (count > 0) {
                    count--;
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P791CustomSortString().new Solution();
        
    } 
}