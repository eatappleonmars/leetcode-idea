package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P125ValidPalindromeTest {

    P125ValidPalindrome.Solution sol = new P125ValidPalindrome().new Solution();

    @Test
    public void test1() {
        final String s = "A man, a plan, a canal: Panama";
        assertTrue(sol.isPalindrome(s));
    }

    @Test
    public void test2() {
        final String s = "race a car";
        assertFalse(sol.isPalindrome(s));
    }
}