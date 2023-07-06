package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P6ZigzagConversionTest {

    P6ZigzagConversion.Solution sol = new P6ZigzagConversion().new Solution();

    @Test
    public void test1() {
        final String s = "PAYPALISHIRING";
        final int numRows = 3;
        assertEquals("PAHNAPLSIIGYIR", sol.convert(s, numRows));
    }
}