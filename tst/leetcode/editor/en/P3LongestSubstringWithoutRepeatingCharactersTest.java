package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P3LongestSubstringWithoutRepeatingCharactersTest {

    P3LongestSubstringWithoutRepeatingCharacters.Solution sol = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();

    @Test
    public void test4() {
        assertEquals(2, sol.lengthOfLongestSubstring("aab"));
    }

    @Test
    public void test5() {
        assertEquals(3, sol.lengthOfLongestSubstring("dvdf"));
    }
}