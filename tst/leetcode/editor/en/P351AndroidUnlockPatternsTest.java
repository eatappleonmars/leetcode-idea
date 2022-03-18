package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P351AndroidUnlockPatternsTest {

    P351AndroidUnlockPatterns.Solution sol = new P351AndroidUnlockPatterns().new Solution();

    @Test
    public void test1() {
        int m = 1;
        int n = 1;
        assertEquals(9, sol.numberOfPatterns(m, n));
    }

    @Test
    public void test2() {
        int m = 1;
        int n = 2;
        assertEquals(65, sol.numberOfPatterns(m, n));
    }
}