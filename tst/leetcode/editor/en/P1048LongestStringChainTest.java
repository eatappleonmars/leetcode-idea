package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1048LongestStringChainTest {
    private P1048LongestStringChain.Solution sol = new P1048LongestStringChain().new Solution();

    @Test
    public void test1() {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        assertEquals(4, sol.longestStrChain(words));
    }

    @Test
    public void test2() {
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        assertEquals(5, sol.longestStrChain(words));
    }

    @Test
    public void test3() {
        String[] words = {"abcd","dbqca"};
        assertEquals(1, sol.longestStrChain(words));
    }
}