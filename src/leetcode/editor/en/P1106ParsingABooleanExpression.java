//A boolean expression is an expression that evaluates to either true or false. 
//It can be in one of the following shapes: 
//
// 
// 't' that evaluates to true. 
// 'f' that evaluates to false. 
// '!(subExpr)' that evaluates to the logical NOT of the inner expression 
//subExpr. 
// '&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of 
//the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1. 
// '|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of 
//the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1. 
// 
//
// Given a string expression that represents a boolean expression, return the 
//evaluation of that expression. 
//
// It is guaranteed that the given expression is valid and follows the given 
//rules. 
//
// 
// Example 1: 
//
// 
//Input: expression = "&(|(f))"
//Output: false
//Explanation: 
//First, evaluate |(f) --> f. The expression is now "&(f)".
//Then, evaluate &(f) --> f. The expression is now "f".
//Finally, return false.
// 
//
// Example 2: 
//
// 
//Input: expression = "|(f,f,f,t)"
//Output: true
//Explanation: The evaluation of (false OR false OR false OR true) is true.
// 
//
// Example 3: 
//
// 
//Input: expression = "!(&(f,t))"
//Output: true
//Explanation: 
//First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression 
//is now "!(f)".
//Then, evaluate !(f) --> NOT false --> true. We return true.
// 
//
// 
// Constraints: 
//
// 
// 1 <= expression.length <= 2 * 10⁴ 
// expression[i] is one following characters: '(', ')', '&', '|', '!', 't', 'f',
// and ','. 
// 
//
// Related Topics String Stack Recursion 👍 1150 👎 61


package leetcode.editor.en;

// 2024-05-25 14:48:04

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P1106ParsingABooleanExpression {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final Deque<Character> operatorStack = new LinkedList<>();
        private final Deque<Boolean> operandStack = new LinkedList<>();
        private final Deque<Integer> operandCountStack = new LinkedList<>();

        public boolean parseBoolExpr(String expression) {
            char currOperator = '|';
            int currOperandCount = 0;
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == '&' || c == '|' || c == '!') {
                    operatorStack.offerLast(currOperator);
                    operandCountStack.offerLast(currOperandCount); // currOperandCount could be 0 here, example, &(!(t))
                    currOperator = c;
                    currOperandCount = 0;
                    i++; // skip '('
                } else if (c == 't' || c == 'f') {
                    operandStack.offerLast(c == 't');
                    currOperandCount++;
                } else if (c == ')') {
                    boolean evaluatedResult = evaluateExpression(currOperator, currOperandCount);
                    operandStack.offerLast(evaluatedResult);
                    currOperator = operatorStack.isEmpty() ? '|' : operatorStack.pollLast();
                    currOperandCount = operandCountStack.isEmpty() ? 1 : operandCountStack.pollLast() + 1; // +1 due to evaluatedResult
                }
            }
            return operandStack.pollLast();
        }

        private boolean evaluateExpression(char operator, int operandCount) {
            List<Boolean> operands = new ArrayList<>();
            while (operandCount > 0) {
                operands.add(operandStack.pollLast());
                operandCount--;
            }
            if (operator == '&') {
                return evaluateAND(operands);
            }
            if (operator == '|') {
                return evaluateOR(operands);
            }
            if (operator == '!') {
                return evaluateNegate(operands.get(0));
            }
            // Never reach here
            return true;
        }

        private boolean evaluateAND(List<Boolean> operands) {
            for (boolean operand : operands) {
                if (!operand) {
                    return false;
                }
            }
            return true;
        }

        private boolean evaluateOR(List<Boolean> operands) {
            for (boolean operand : operands) {
                if (operand) {
                    return true;
                }
            }
            return false;
        }

        private boolean evaluateNegate(Boolean operand) {
            return !operand;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1106ParsingABooleanExpression().new Solution();
        
    } 
}