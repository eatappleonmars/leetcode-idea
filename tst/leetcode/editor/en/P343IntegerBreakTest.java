package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P343IntegerBreakTest {

    P343IntegerBreak.Solution sol = new P343IntegerBreak().new Solution();

    @Test
    public void test3() {
        assertEquals(2, sol.integerBreak(3));
    }
}