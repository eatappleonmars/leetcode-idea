package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P340LongestSubstringWithAtMostKDistinctCharactersTest {

    P340LongestSubstringWithAtMostKDistinctCharacters.Solution sol =
            new P340LongestSubstringWithAtMostKDistinctCharacters().new Solution();

    @Test
    public void test1() {
        final String s = "aa";
        final int k = 2;
        int res = sol.lengthOfLongestSubstringKDistinct(s, k);
        assertEquals(2, res);
    }

    @Test
    public void test2() {
        final String s = "eceba";
        final int k = 2;
        int res = sol.lengthOfLongestSubstringKDistinct(s, k);
        assertEquals(3, res);
    }

    @Test
    public void test3() {
        final String s = "aabcbb";
        final int k = 2;
        int res = sol.lengthOfLongestSubstringKDistinct(s, k);
        assertEquals(4, res);
    }

    @Test
    public void test4() {
        final String s = "abaccc";
        final int k = 2;
        int res = sol.lengthOfLongestSubstringKDistinct(s, k);
        assertEquals(4, res);
    }
}