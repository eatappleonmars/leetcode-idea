package leetcode.editor.en;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1106ParsingABooleanExpressionTest {

    private P1106ParsingABooleanExpression.Solution sol = new P1106ParsingABooleanExpression().new Solution();

    @Test
    public void test1() {
        String expression = "t";
        assertTrue(sol.parseBoolExpr(expression));
    }

    @Test
    public void test2() {
        String expression = "!(f)";
        assertTrue(sol.parseBoolExpr(expression));
    }

    @Test
    public void test3() {
        String expression = "&(t,f)";
        assertFalse(sol.parseBoolExpr(expression));
    }

    @Test
    public void test4() {
        String expression = "|(t,f)";
        assertTrue(sol.parseBoolExpr(expression));
    }

    @Test
    public void test5() {
        String expression = "&(|(f))";
        assertFalse(sol.parseBoolExpr(expression));
    }

    @Test
    public void test6() {
        String expression = "|(t,&(t,f))";
        assertTrue(sol.parseBoolExpr(expression));
    }
}