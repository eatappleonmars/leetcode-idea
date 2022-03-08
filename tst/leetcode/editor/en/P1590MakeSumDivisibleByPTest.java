package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1590MakeSumDivisibleByPTest {

    P1590MakeSumDivisibleByP.Solution sol = new P1590MakeSumDivisibleByP().new Solution();

    @Test
    public void test1() {
        int[] nums = {3,1,4,2};
        int p = 6;
        assertEquals(1, sol.minSubarray(nums, p));
    }

    @Test
    public void test2() {
        int[] nums = {6,3,5,2};
        int p = 9;
        assertEquals(2, sol.minSubarray(nums, p));
    }

    @Test
    public void test3() {
        int[] nums = {8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2};
        int p = 148;
        assertEquals(7, sol.minSubarray(nums, p));
    }
}