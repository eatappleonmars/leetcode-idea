package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P215KthLargestElementInAnArrayTest {

    private static P215KthLargestElementInAnArray.Solution sol = new P215KthLargestElementInAnArray().new Solution();

    @Test
    public void test1() {
        final int[] nums = {3,2,1,5,6,4};
        final int k = 2;
        assertEquals(5, sol.findKthLargest(nums, k));
    }

    @Test
    public void test2() {
        final int[] nums = {3,2,3,1,2,4,5,5,6};
        final int k = 4;
        assertEquals(4, sol.findKthLargest(nums, k));
    }
}