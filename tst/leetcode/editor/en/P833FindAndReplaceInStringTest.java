package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P833FindAndReplaceInStringTest {
    private P833FindAndReplaceInString.Solution sol = new P833FindAndReplaceInString().new Solution();

    @Test
    public void test1() {
        final String s = "abcd";
        final int[] indices = {0, 2};
        final String[] sources = {"a", "cd"};
        final String[] targets = {"eee", "ffff"};
        final String res = sol.findReplaceString(s, indices, sources, targets);
        assertEquals("eeebffff", res);
    }

    @Test
    public void test2() {
        final String s = "abcd";
        final int[] indices = {0, 2};
        final String[] sources = {"ab","ec"};
        final String[] targets = {"eee", "ffff"};
        final String res = sol.findReplaceString(s, indices, sources, targets);
        assertEquals("eeecd", res);
    }

    @Test
    public void test3() {
        final String s = "vmokgggqzp";
        final int[] indices = {3,5,1};
        final String[] sources = {"kg","ggq","mo"};
        final String[] targets = {"s","so","bfr"};
        final String res = sol.findReplaceString(s, indices, sources, targets);
        assertEquals("vbfrssozp", res);
    }
}