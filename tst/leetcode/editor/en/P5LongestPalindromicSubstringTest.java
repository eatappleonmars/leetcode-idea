package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P5LongestPalindromicSubstringTest {

    P5LongestPalindromicSubstring.Solution sol = new P5LongestPalindromicSubstring().new Solution();

    @Test
    public void test2() {
        String s = "abbc";
        assertEquals("bb", sol.longestPalindrome(s));
    }
}