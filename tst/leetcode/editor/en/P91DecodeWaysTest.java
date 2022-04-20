package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P91DecodeWaysTest {

    P91DecodeWays.Solution sol = new P91DecodeWays().new Solution();

    @Test
    public void test1() {
        String s = "12";
        assertEquals(2, sol.numDecodings(s));
    }

    @Test
    public void test2() {
        String s = "226";
        assertEquals(3, sol.numDecodings(s));
    }

    @Test
    public void test3() {
        String s = "06";
        assertEquals(0, sol.numDecodings(s));
    }

    @Test
    public void test4() {
        String s = "10";
        assertEquals(1, sol.numDecodings(s));
    }
}