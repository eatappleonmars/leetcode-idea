//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 👍 13743 👎 629


package leetcode.editor.en;

// 2022-06-24 09:21:37

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class P20ValidParentheses {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {

            Map<Character, Character> mapping = Map.of(
                    '(', ')',
                    '[', ']',
                    '{', '}'
            );

            Deque<Character> stack = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (mapping.containsKey(c)) {
                    stack.offerFirst(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char first = stack.peekFirst();
                    if (c != mapping.get(first)) {
                        return false;
                    }
                    stack.pollFirst();
                }
            }
            return stack.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P20ValidParentheses().new Solution();
        
    } 
}