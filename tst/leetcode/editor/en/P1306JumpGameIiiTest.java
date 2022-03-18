package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1306JumpGameIiiTest {

    P1306JumpGameIii.Solution sol = new P1306JumpGameIii().new Solution();

    @Test
    public void test1() {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        assertTrue(sol.canReach(arr, start));
    }
}