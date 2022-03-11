package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1915NumberOfWonderfulSubstringsTest {

    P1915NumberOfWonderfulSubstrings.Solution sol = new P1915NumberOfWonderfulSubstrings().new Solution();

    @Test
    public void test4() {
        String word = "aa";
        assertEquals(3, sol.wonderfulSubstrings(word));
    }
}