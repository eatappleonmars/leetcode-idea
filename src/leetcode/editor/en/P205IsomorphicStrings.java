//Given two strings s and t, determine if they are isomorphic. 
//
// Two strings s and t are isomorphic if the characters in s can be replaced to 
//get t. 
//
// All occurrences of a character must be replaced with another character while 
//preserving the order of characters. No two characters may mapping to the same 
//character, but a character may mapping to itself. 
//
// 
// Example 1: 
// Input: s = "egg", t = "add"
//Output: true
// 
// Example 2: 
// Input: s = "foo", t = "bar"
//Output: false
// 
// Example 3: 
// Input: s = "paper", t = "title"
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// t.length == s.length 
// s and t consist of any valid ascii character. 
// 
//
// Related Topics Hash Table String 👍 7088 👎 1530


package leetcode.editor.en;

// 2023-07-09 13:04:35

import java.util.Arrays;

public class P205IsomorphicStrings {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {

            int[] mapping = new int[256];
            Arrays.fill(mapping, -1);
            boolean[] mapped = new boolean[256];

            for (int i = 0; i < s.length(); i++) {
                char si = s.charAt(i);
                char ti = t.charAt(i);
                if (mapping[si] == -1) {
                    if (mapped[ti]) {
                        return false;
                    }
                    mapping[si] = ti;
                    mapped[ti] = true;
                } else if (mapping[si] != ti) {
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
        Solution sol = new P205IsomorphicStrings().new Solution();
        
    } 
}