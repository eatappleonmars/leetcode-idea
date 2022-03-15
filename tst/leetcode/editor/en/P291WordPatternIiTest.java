package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P291WordPatternIiTest {

    P291WordPatternIi.Solution sol = new P291WordPatternIi().new Solution();

    @Test
    public void test1() {
        String pattern = "abab";
        String s = "redblueredblue";
        assertTrue(sol.wordPatternMatch(pattern, s));
    }

    @Test
    public void test2() {
        String pattern = "aaaa";
        String s = "asdasdasdasd";
        assertTrue(sol.wordPatternMatch(pattern, s));
    }

    @Test
    public void test3() {
        String pattern = "aabb";
        String s = "xyzabcxzyabc";
        assertFalse(sol.wordPatternMatch(pattern, s));
    }

    @Test
    public void test4() {
        String pattern = "ab";
        String s = "cdd";
        assertTrue(sol.wordPatternMatch(pattern, s));
    }

    @Test
    public void test5() {
        String pattern = "ab";
        String s = "aa";
        assertFalse(sol.wordPatternMatch(pattern, s));
    }
}