package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P792NumberOfMatchingSubsequencesTest {
    private P792NumberOfMatchingSubsequences.Solution sol = new P792NumberOfMatchingSubsequences().new Solution();

    @Test
    public void test1() {
        final String s = "abcde";
        final String[] words = {"a","bb","acd","ace"};
        assertEquals(3, sol.numMatchingSubseq(s, words));
    }

    @Test
    public void test2() {
        final String s = "dsahjpjauf";
        final String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        assertEquals(2, sol.numMatchingSubseq(s, words));
    }
}