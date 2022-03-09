package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1542FindLongestAwesomeSubstringTest {

    P1542FindLongestAwesomeSubstring.Solution sol = new P1542FindLongestAwesomeSubstring().new Solution();

    @Test
    public void test4() {
        String s = "76263";
        assertEquals(3, sol.longestAwesome(s));
    }
}