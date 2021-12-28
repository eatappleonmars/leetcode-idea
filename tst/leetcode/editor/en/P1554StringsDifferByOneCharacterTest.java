package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1554StringsDifferByOneCharacterTest {
    P1554StringsDifferByOneCharacter.Solution sol = new P1554StringsDifferByOneCharacter().new Solution();

    @Test
    public void test1() {
        final String[] dict = {"abcd","acbd", "aacd"};
        assertTrue(sol.differByOne(dict));
    }

    @Test
    public void test2() {
        final String[] dict = {"ab","cd","yz"};
        assertFalse(sol.differByOne(dict));
    }

    @Test
    public void test3() {
        final String[] dict = {"abcd","cccc","abyd","abab"};
        assertTrue(sol.differByOne(dict));
    }
}