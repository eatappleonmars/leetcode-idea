package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1047RemoveAllAdjacentDuplicatesInStringTest {
    public P1047RemoveAllAdjacentDuplicatesInString.Solution sol =
            new P1047RemoveAllAdjacentDuplicatesInString().new Solution();

    @Test
    public void test1() {
        final String s = "abbac";
        String res = sol.removeDuplicates(s);
        assertEquals("c", res);
    }

    @Test
    public void test2() {
        final String s = "abbbac";
        String res = sol.removeDuplicates(s);
        assertEquals("abac", res);
    }
}