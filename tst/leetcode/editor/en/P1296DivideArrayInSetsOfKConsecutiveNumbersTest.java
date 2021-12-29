package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1296DivideArrayInSetsOfKConsecutiveNumbersTest {
    P1296DivideArrayInSetsOfKConsecutiveNumbers.Solution sol =
            new P1296DivideArrayInSetsOfKConsecutiveNumbers().new Solution();

    @Test
    public void test1() {
        final int[] nums = {1,2,3,3,4,4,5,6};
        final int k = 4;
        assertTrue(sol.isPossibleDivide(nums, k));
    }

    @Test
    public void test2() {
        final int[] nums = {3,2,1,2,3,4,3,4,5,9,10,11};
        final int k = 3;
        assertTrue(sol.isPossibleDivide(nums, k));
    }

    @Test
    public void test3() {
        final int[] nums = {1,2,3,4};
        final int k = 3;
        assertFalse(sol.isPossibleDivide(nums, k));
    }
    @Test
    public void test4() {
        final int[] nums = {1,1,2,2,3,3};
        final int k = 2;
        assertFalse(sol.isPossibleDivide(nums, k));
    }
}