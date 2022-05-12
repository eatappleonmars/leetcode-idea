package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P772BasicCalculatorIiiTest {

    P772BasicCalculatorIii.Solution sol = new P772BasicCalculatorIii().new Solution();

    @Test
    public void test1() {
        String s = "1+1";
        assertEquals(2, sol.calculate(s));
    }

    @Test
    public void test2() {
        String s = "1-1";
        assertEquals(0, sol.calculate(s));
    }

    @Test
    public void test3() {
        String s = "1-1+1";
        assertEquals(1, sol.calculate(s));
    }

    @Test
    public void test4() {
        String s = "1-2*3+4";
        assertEquals(-1, sol.calculate(s));
    }

    @Test
    public void test5() {
        String s = "1+(1+2*3)";
        assertEquals(8, sol.calculate(s));
    }

    @Test
    public void test6() {
        String s = "2*(1+2*3)+5";
        assertEquals(19, sol.calculate(s));
    }

    @Test
    public void test7() {
        String s = "1+((1+2*3)*2-(1-2))";
        assertEquals(16, sol.calculate(s));
    }

    @Test
    public void test8() {
        String s = "(2+6*3+5-(3*14/7+2)*5)+3"; // (25-(8)*5))+3 = -15+3 = -12
        assertEquals(-12, sol.calculate(s));
    }


}