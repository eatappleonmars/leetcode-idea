//Given a string s representing a valid expression, implement a basic 
//calculator to evaluate it, and return the result of the evaluation. 
//
// Note: You are not allowed to use any built-in function which evaluates 
//strings as mathematical expressions, such as eval(). 
//
// 
// Example 1: 
//
// 
//Input: s = "1 + 1"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: s = " 2-1 + 2 "
//Output: 3
// 
//
// Example 3: 
//
// 
//Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consists of digits, '+', '-', '(', ')', and ' '. 
// s represents a valid expression. 
// '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid). 
//
// '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid). 
//
// There will be no two consecutive operators in the input. 
// Every number and running calculation will fit in a signed 32-bit integer. 
// 
// Related Topics Math String Stack Recursion 👍 3576 👎 298


package leetcode.editor.en;

// 2022-05-09 08:59:19

import java.util.Deque;
import java.util.LinkedList;

public class P224BasicCalculator {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            // Remove all white space characters
            char[] chars = new char[s.length()];
            int length = 0;
            for (char c : s.toCharArray()) {
                if (c != ' ') {
                    chars[length++] = c;
                }
            }

//            return recursiveCalculation(chars, new int[]{0}, length);
            return iterativeCalculation(chars, length);
        }

        private int iterativeCalculation(char[] sChars, int length) {

            Deque<Integer> ltOperandStack = new LinkedList<>();
            Deque<Character> operatorStack = new LinkedList<>();

            int ltOperand = 0;
            char operator = '+';

            int index = 0;
            while (index < length) {
                char c = sChars[index];

                if (c == '+' || c == '-') {
                    operator = c;
                    index++;
                } else  if (c == '(') {
                    ltOperandStack.offerFirst(ltOperand);
                    operatorStack.offerFirst(operator);
                    // reset
                    ltOperand = 0;
                    operator = '+';
                    index++;
                } else {
                    int rtOperand;
                    if (c == ')') {
                        rtOperand = ltOperand;
                        ltOperand = ltOperandStack.pollFirst();
                        operator = operatorStack.pollFirst();
                        index++;
                    } else {
                        rtOperand = 0;
                        while (index < length && Character.isDigit(sChars[index])) {
                            rtOperand = rtOperand * 10 + sChars[index] - '0';
                            index++;
                        }
                    }
                    ltOperand += operator == '+' ? rtOperand : -rtOperand;
                }
            }

            return ltOperand;
        }

        private int recursiveCalculation(char[] sChars, int[] index, int length) {

            int ltOperand = 0;
            char operator = '+';

            while (index[0] < length) {

                char c = sChars[index[0]];

                // Current level of recursion ends
                if (c == ')') {
                    index[0]++;
                    break;
                }
                
                if (c == '+' || c == '-') {
                    index[0]++;
                    operator = c;
                } else { // compute
                    int rtOperand = 0;
                    if (c == '(') { // Let next level recursion does the computation
                        index[0]++;
                        rtOperand = recursiveCalculation(sChars, index, length);
                    }
                    else { // parse the number
                        while (index[0] < length && Character.isDigit(sChars[index[0]])) {
                            rtOperand = rtOperand * 10 + sChars[index[0]] - '0';
                            index[0]++;
                        }
                    }
                    ltOperand += operator == '+' ? rtOperand : -rtOperand;
                }
            }
            return ltOperand;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P224BasicCalculator().new Solution();
        
    } 
}