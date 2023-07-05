package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P151ReverseWordsInAStringTest {

    P151ReverseWordsInAString.Solution sol = new P151ReverseWordsInAString().new Solution();

    @Test
    public void test1() {
        final String s = "the sky is blue";
        final String expected = "blue is sky the";
        assertEquals(expected, sol.reverseWords(s));
    }

    @Test
    public void test2() {
        final String s = "  hello world  ";
        final String expected = "world hello";
        assertEquals(expected, sol.reverseWords(s));
    }

    @Test
    public void test3() {
        final String s = "a good   example";
        final String expected = "example good a";
        assertEquals(expected, sol.reverseWords(s));
    }
}