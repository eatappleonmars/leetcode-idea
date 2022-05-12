//Given a string s which represents an expression, evaluate this expression and 
//return its value. 
//
// The integer division should truncate toward zero. 
//
// You may assume that the given expression is always valid. All intermediate 
//results will be in the range of [-2³¹, 2³¹ - 1]. 
//
// Note: You are not allowed to use any built-in function which evaluates 
//strings as mathematical expressions, such as eval(). 
//
// 
// Example 1: 
// Input: s = "3+2*2"
//Output: 7
// Example 2: 
// Input: s = " 3/2 "
//Output: 1
// Example 3: 
// Input: s = " 3+5 / 2 "
//Output: 5
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consists of integers and operators ('+', '-', '*', '/') separated by some 
//rtOperand of spaces. 
// s represents a valid expression. 
// All the integers in the expression are non-negative integers in the range [0,
// 2³¹ - 1]. 
// The answer is guaranteed to fit in a 32-bit integer. 
// 
// Related Topics Math String Stack 👍 4271 👎 565


package leetcode.editor.en;

// 2022-05-10 10:07:50

import java.util.Deque;
import java.util.LinkedList;

public class P227BasicCalculatorIi {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            char[] sChars = s.toCharArray();
            int length = 0;
            // Remove all white space characters
            for (char c : sChars) {
                if (c != ' ') {
                    sChars[length] = c;
                    length++;
                }
            }
            return iterativeCalculation(sChars, length);
        }

        private int iterativeCalculation(char[] sChars, int length) {

            Deque<Integer> operandStack = new LinkedList<>();
            char prevOperator = '+';

            for (int i = 0; i < length;) {
                char c = sChars[i];
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    prevOperator = c;
                    i++;
                } else {
                    int operand = 0;
                    while (i < length && Character.isDigit(sChars[i])) {
                        operand = operand * 10 + sChars[i] - '0';
                        i++;
                    }
                    if (prevOperator == '*' || prevOperator == '/') {
                        int prevOperand = operandStack.pollFirst();
                        operand = prevOperator == '*' ? prevOperand * operand : prevOperand / operand;
                    } else {
                        operand = prevOperator == '+'? operand : -operand;
                    }
                    operandStack.offerFirst(operand);
                }
            }

            int res = 0;
            while (!operandStack.isEmpty()) {
                res += operandStack.pollFirst();
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P227BasicCalculatorIi().new Solution();
        
    } 
}