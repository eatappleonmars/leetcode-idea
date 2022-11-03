//A parentheses string is valid if and only if:
//
// 
// It is the empty string, 
// It can be written as AB (A concatenated with B), where A and B are valid 
//strings, or 
// It can be written as (A), where A is a valid string. 
// 
//
// You are given a parentheses string s. In one move, you can insert a 
//parenthesis at any position of the string. 
//
// 
// For example, if s = "()))", you can insert an opening parenthesis to be "(())
//)" or a closing parenthesis to be "())))". 
// 
//
// Return the minimum number of moves required to make s valid. 
//
// 
// Example 1: 
//
// 
//Input: s = "())"
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: s = "((("
//Output: 3
// 
//
// Example 3: 
//
// 
//Input: s = "()"
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: s = "()))(("
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s[i] is either '(' or ')'. 
// 
// Related Topics String Stack Greedy 👍 1845 👎 105


package leetcode.editor.en;

// 2021-11-22 21:45:02

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class P921MinimumAddToMakeParenthesesValid {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minAddToMakeValid(String s) {
            return solveWithCounting(s);
//            return solveWithStack(s);
        }

        private int solveWithCounting(String s) {
            int ltpCount = 0;
            int rtpCount = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    ltpCount++;
                } else if (ltpCount > 0) {
                    ltpCount--;
                } else {
                    rtpCount++;
                }
            }
            return ltpCount + rtpCount;
        }

        private int solveWithStack(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ')' && !stack.isEmpty() && stack.peekFirst() == '(') {
                    stack.pollFirst();
                } else {
                    stack.offerFirst(c);
                }
            }
            return stack.size();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P921MinimumAddToMakeParenthesesValid().new Solution();
        
    } 
}