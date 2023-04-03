package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P139WordBreakTest {

    P139WordBreak.Solution sol = new P139WordBreak().new Solution();

    @Test
    public void test1() {
        String s = "leetcode";
        List<String> wordDict = List.of("leet","code");
        assertTrue(sol.wordBreak(s, wordDict));
    }

    @Test
    public void test2() {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple","pen");
        assertTrue(sol.wordBreak(s, wordDict));
    }

    @Test
    public void test3() {
        String s = "catsandog";
        List<String> wordDict = List.of("cats","dog","sand","and","cat");
        assertFalse(sol.wordBreak(s, wordDict));
    }
}