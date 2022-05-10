package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P224BasicCalculatorTest {

    P224BasicCalculator.Solution sol = new P224BasicCalculator().new Solution();

    @Test
    public void test1() {
        String s = " 1 +  2  ";
        System.out.println(s);
        assertEquals(3, sol.calculate(s));
    }
    @Test
    public void test2() {
        String s = " ( 1 +  2  ) ";
        System.out.println(s);
        assertEquals(3, sol.calculate(s));
    }

    @Test
    public void test3() {
        String s = " 1 +  (2 +  3   )  ";
        System.out.println(s);
        assertEquals(6, sol.calculate(s));
    }

    @Test
    public void test4() {
        String s = " 1 + ( ( 2 + 3 )+  ( 4+5)) ";
        System.out.println(s);
        assertEquals(15, sol.calculate(s));
    }
}