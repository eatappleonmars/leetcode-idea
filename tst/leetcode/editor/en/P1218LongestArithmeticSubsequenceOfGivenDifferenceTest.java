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
        final int[] arr = {4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8};
        final int difference = 0;
        assertEquals(2, sol.longestSubsequence(arr, difference));
    }
}