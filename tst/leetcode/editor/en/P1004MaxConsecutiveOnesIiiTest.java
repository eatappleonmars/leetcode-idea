package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1004MaxConsecutiveOnesIiiTest {
    P1004MaxConsecutiveOnesIii.Solution sol = new P1004MaxConsecutiveOnesIii().new Solution();

    @Test
    public void test1() {
        final int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        final int k = 2;
        int res = sol.longestOnes(nums, k);
        assertEquals(6, res);
    }

    @Test
    public void test2() {
        final int[] nums = {1, 0, 0, 0};
        final int k = 1;
        int res = sol.longestOnes(nums, k);
        assertEquals(2, res);
    }
}