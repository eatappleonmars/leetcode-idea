package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P33SearchInRotatedSortedArrayTest {

    P33SearchInRotatedSortedArray.Solution sol = new P33SearchInRotatedSortedArray().new Solution();

    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        int target = 1;
        assertEquals(0, sol.search(nums, target));
    }

    @Test
    public void test2() {
        int[] nums = {3, 1, 2};
        int target = 3;
        assertEquals(0, sol.search(nums, target));
    }

    @Test
    public void test3() {
        int[] nums = {1};
        int target = 0;
        assertEquals(-1, sol.search(nums, target));
    }
}