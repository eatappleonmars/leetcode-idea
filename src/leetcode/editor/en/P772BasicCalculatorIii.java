//Implement a basic calculator to evaluate a simple expression string. 
//
// The expression string contains only non-negative integers, '+', '-', '*', '/
//' operators, and open '(' and closing parentheses ')'. The integer division 
//should truncate toward zero. 
//
// You may assume that the given expression is always valid. All intermediate 
//results will be in the range of [-2³¹, 2³¹ - 1]. 
//
// Note: You are not allowed to use any built-in function which evaluates 
//strings as mathematical expressions, such as eval(). 
//
// 
// Example 1: 
//
// 
//Input: s = "1+1"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: s = "6-4/2"
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: s = "2*(5+5*2)/3+(6/2+8)"
//Output: 21
// 
//
// 
// Constraints: 
//
// 
// 1 <= s <= 10⁴ 
// s consists of digits, '+', '-', '*', '/', '(', and ')'. 
// s is a valid expression. 
// 
// Related Topics Math String Stack Recursion 👍 865 👎 247


package leetcode.editor.en;

// 2022-05-12 08:52:22

import java.util.Deque;
import java.util.LinkedList;

public class P772BasicCalculatorIii {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            char[] sChars = s.toCharArray();
            return calculate(sChars, new int[]{0});
        }

        private int calculate(char[] sChars, int[] index) {

            Deque<Integer> operandStack = new LinkedList<>();
            char prevOperator = '+';

            while (index[0] < sChars.length) {

                final char c = sChars[index[0]];
                index[0]++;

                if (c == ')') {
                    break;
                }
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    prevOperator = c;
                    continue;
                }

                int operand = 0;
                if (c == '(') {
                    operand = calculate(sChars, index);
                } else {
                    operand = c - '0';
                    while (index[0] < sChars.length && Character.isDigit(sChars[index[0]])) {
                        operand = operand * 10 + sChars[index[0]] - '0';
                        index[0]++;
                    }
                }

                if (prevOperator == '*') {
                    operand = operandStack.pollFirst() * operand;
                } else if (prevOperator == '/') {
                    operand = operandStack.pollFirst() / operand;
                } else if (prevOperator == '-') {
                    operand = -operand;
                }
                operandStack.offerFirst(operand);
            }

            int sum = 0;
            while (!operandStack.isEmpty()) {
                sum += operandStack.pollFirst();
            }
            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P772BasicCalculatorIii().new Solution();
        
    } 
}