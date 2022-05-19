package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P41FirstMissingPositiveTest {

    P41FirstMissingPositive.Solution sol = new P41FirstMissingPositive().new Solution();

    @Test
    public void test1() {
        int[] nums = {1, 2, 0};
        assertEquals(3, sol.firstMissingPositive(nums));
    }

    @Test
    public void test2() {
        int[] nums = {3, 4, -1, 1};
        assertEquals(2, sol.firstMissingPositive(nums));
    }

    @Test
    public void test3() {
        int[] nums = {7, 8, 9};
        assertEquals(1, sol.firstMissingPositive(nums));
    }

    @Test
    public void test4() {
        int[] nums = {0, 1, 2};
        assertEquals(3, sol.firstMissingPositive(nums));
    }
}