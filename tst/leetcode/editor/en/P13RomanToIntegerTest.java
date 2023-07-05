package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P13RomanToIntegerTest {

    P13RomanToInteger.Solution sol = new P13RomanToInteger().new Solution();

    @Test
    public void test1() {
        final String s = "III";
        assertEquals(3, sol.romanToInt(s));
    }
}