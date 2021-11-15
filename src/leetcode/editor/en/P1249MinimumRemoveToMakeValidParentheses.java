//Given a string s of '(' , ')' and lowercase English characters. 
//
// Your task is to remove the minimum number of parentheses ( '(' or ')', in 
//any positions ) so that the resulting parentheses string is valid and return any 
//valid string. 
//
// Formally, a parentheses string is valid if and only if: 
//
// 
// It is the empty string, contains only lowercase characters, or 
// It can be written as AB (A concatenated with B), where A and B are valid 
//strings, or 
// It can be written as (A), where A is a valid string. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
//Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
// 
//
// Example 2: 
//
// 
//Input: s = "a)b(c)d"
//Output: "ab(c)d"
// 
//
// Example 3: 
//
// 
//Input: s = "))(("
//Output: ""
//Explanation: An empty string is also valid.
// 
//
// Example 4: 
//
// 
//Input: s = "(a(b(c)d)"
//Output: "a(b(c)d)"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is either'(' , ')', or lowercase English letter. 
// 
// Related Topics String Stack 👍 2987 👎 64


package leetcode.editor.en;

// 2021-11-15 09:37:49

import java.util.LinkedList;

public class P1249MinimumRemoveToMakeValidParentheses {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final char LT_PARENTHESES = '(';
        private static final char RT_PARENTHESES = ')';
        private static final char WILDCARD = '*';

        public String minRemoveToMakeValid(String s) {

            final LinkedList<Integer> stack = new LinkedList<>();
            final char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                final char c = chars[i];
                if (c == LT_PARENTHESES) {
                    stack.offerFirst(i);
                } else if (c == RT_PARENTHESES) {
                    if (stack.isEmpty()) {
                        chars[i] = WILDCARD;
                    } else {
                        stack.pollFirst();
                    }
                }
            }

            return updateString(chars, stack);
        }

        private String updateString(final char[] chars, final LinkedList<Integer> stack) {
            while (!stack.isEmpty()) {
                int rmIndex = stack.pollFirst();
                chars[rmIndex] = WILDCARD;
            }

            int rIndex = 0;
            int wIndex = 0;

            while (rIndex < chars.length) {
                if (chars[rIndex] != WILDCARD) {
                    chars[wIndex] = chars[rIndex];
                    wIndex++;
                }
                rIndex++;
            }

            return new String(chars, 0, wIndex);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1249MinimumRemoveToMakeValidParentheses().new Solution();

        final String s1 = "lee(t(c)o)de)";
        System.out.println(sol.minRemoveToMakeValid(s1));

        final String s2 = "a)b(c)d";
        System.out.println(sol.minRemoveToMakeValid(s2));

        final String s3 = "))((";
        System.out.println(sol.minRemoveToMakeValid(s3));

        final String s4 = "(a(b(c)d)";
        System.out.println(sol.minRemoveToMakeValid(s4));

    } 
}