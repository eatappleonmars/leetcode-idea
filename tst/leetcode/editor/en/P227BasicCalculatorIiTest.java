package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P227BasicCalculatorIiTest {

    P227BasicCalculatorIi.Solution sol = new P227BasicCalculatorIi().new Solution();

    @Test
    public void test1() {
        String s = " 1 + 2 * 3 ";
        assertEquals(7, sol.calculate(s));
    }

    @Test
    public void test2() {
        String s = " 2 * 3  + 1 ";
        assertEquals(7, sol.calculate(s));
    }

    @Test
    public void test3() {
        String s = " 2 * 3  + 3 * 4 ";
        assertEquals(18, sol.calculate(s));
    }

    @Test
    public void test4() {
        String s = " 1 - 1 + 1 ";
        assertEquals(1, sol.calculate(s));
    }
}