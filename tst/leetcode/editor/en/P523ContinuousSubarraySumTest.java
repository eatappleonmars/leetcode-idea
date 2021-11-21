package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class P523ContinuousSubarraySumTest {

    private final static P523ContinuousSubarraySum.Solution sol = new P523ContinuousSubarraySum().new Solution();

    @Test
    public void test1() {
        final int[] nums = {23,2,4,6,7};
        final int k = 6;
        assertTrue(sol.checkSubarraySum(nums, k)); // true
    }

    @Test
    public void test2() {
        final int[] nums = {23,2,6,4,7};
        final int k = 6;
        assertTrue(sol.checkSubarraySum(nums, k)); // true
    }

    @Test
    public void test3() {
        final int[] nums = {23,2,6,4,7};
        final int k = 13;
        assertFalse(sol.checkSubarraySum(nums, k)); // true
    }

    @Test
    public void test4() {
        final int[] nums = {23,2,4,6,6};
        final int k = 7;
        assertTrue(sol.checkSubarraySum(nums, k)); // true
    }

    @Test
    public void test5() {
        final int[] nums = {1,0};
        final int k = 7;
        assertFalse(sol.checkSubarraySum(nums, k)); // true
    }

    @Test
    public void test6() {
        final int[] nums = {5,0,0,0};
        final int k = 3;
        assertTrue(sol.checkSubarraySum(nums, k)); // true
    }
}