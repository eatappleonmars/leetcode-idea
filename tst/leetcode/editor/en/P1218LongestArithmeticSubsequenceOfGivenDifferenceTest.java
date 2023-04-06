package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1218LongestArithmeticSubsequenceOfGivenDifferenceTest {
    P1218LongestArithmeticSubsequenceOfGivenDifference.Solution sol = new P1218LongestArithmeticSubsequenceOfGivenDifference().new Solution();

    @Test
    public void test1() {
        final int[] arr = {1,2,3,4};
        final int difference = 1;
        assertEquals(4, sol.longestSubsequence(arr, difference));
    }

    @Test
    public void test2() {
        // [1,3,5,7,9] => len = 5
        // [2,4,6]     => len = 3
        final int[] arr = {1,3,2,4,6,5,7,9};
        final int difference = 2;
        assertEquals(5, sol.longestSubsequence(arr, difference));
    }

    @Test
    public void test3() {
        final int[] arr = {4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8};
        final int difference = 0;
        assertEquals(2, sol.longestSubsequence(arr, difference));
    }

    @Test
    public void test4() {
        final int[] arr = {2,3,1,2,3};
        final int difference = 1;
        assertEquals(3, sol.longestSubsequence(arr, difference));
    }

    @Test
    public void test5() {
        final int[] arr = {1,2,3,2,3};
        final int difference = 1;
        assertEquals(3, sol.longestSubsequence(arr, difference));
    }

    @Test
    public void test6() {
        final int[] arr = {1,2,3,3,4};
        final int difference = 1;
        assertEquals(4, sol.longestSubsequence(arr, difference));
    }
}