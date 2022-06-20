package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P912SortAnArrayTest {

    P912SortAnArray.Solution sol = new P912SortAnArray().new Solution();

    @Test
    public void test1() {
        int[] nums = {1};
        int[] actual = sol.sortArray(nums);
        int[] expect = {1};
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3};
        int[] actual = sol.sortArray(nums);
        int[] expect = {1, 2, 3};
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test3() {
        int[] nums = {3, 2, 1};
        int[] actual = sol.sortArray(nums);
        int[] expect = {1, 2, 3};
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test4() {
        int[] nums = {3, 1, 5, 0, 2, 4, 3};
        int[] actual = sol.sortArray(nums);
        int[] expect = {0, 1, 2, 3, 3, 4, 5};
        assertArrayEquals(expect, actual);
    }
}