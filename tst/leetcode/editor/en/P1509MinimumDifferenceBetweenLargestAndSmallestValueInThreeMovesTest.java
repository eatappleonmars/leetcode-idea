package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1509MinimumDifferenceBetweenLargestAndSmallestValueInThreeMovesTest {
    private static final P1509MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves.Solution sol =
            new P1509MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves().new Solution();

    @Test
    public void test1() {
        final int[] nums = {1,5,0,10,14};
        assertEquals(1, sol.minDifference(nums));
    }

    @Test
    public void test2() {
        final int[] nums = {6,6,0,1,1,4,6};
        assertEquals(2, sol.minDifference(nums));
    }
}