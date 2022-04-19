package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P32LongestValidParenthesesTest {

    P32LongestValidParentheses.Solution sol = new P32LongestValidParentheses().new Solution();

    @Test
    public void test1() {
        final String s = "(()";
        assertEquals(2, sol.longestValidParentheses(s));
    }

    @Test
    public void test2() {
        final String s = ")()())";
        assertEquals(4, sol.longestValidParentheses(s));
    }

    @Test
    public void test3() {
        final String s = "";
        assertEquals(0, sol.longestValidParentheses(s));
    }

    @Test
    public void test4() {
        final String s = "()(()";
        assertEquals(2, sol.longestValidParentheses(s));
    }
}