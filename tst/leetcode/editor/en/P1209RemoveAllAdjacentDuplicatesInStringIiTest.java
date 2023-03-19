package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1209RemoveAllAdjacentDuplicatesInStringIiTest {

    P1209RemoveAllAdjacentDuplicatesInStringIi.Solution sol =
            new P1209RemoveAllAdjacentDuplicatesInStringIi().new Solution();

    @Test
    public void test1() {
        String s = "abcd";
        int k = 2;
        String actual = sol.removeDuplicates(s, k);
        assertEquals("abcd", actual);
    }

    @Test
    public void test2() {
        String s = "deeedbbcccbdaa";
        int k = 3;
        String actual = sol.removeDuplicates(s, k);
        assertEquals("aa", actual);
    }

    @Test
    public void test3() {
        String s = "pbbcggttciiippooaais";
        int k = 2;
        String actual = sol.removeDuplicates(s, k);
        assertEquals("ps", actual);
    }
}