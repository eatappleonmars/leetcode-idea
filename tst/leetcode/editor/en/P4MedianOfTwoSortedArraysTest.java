package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P4MedianOfTwoSortedArraysTest {

    P4MedianOfTwoSortedArrays.Solution sol = new P4MedianOfTwoSortedArrays().new Solution();

    @Test
    public void test1() {
        final int[] nums1 = {1, 3};
        final int[] nums2 = {2};
        assertEquals(2, sol.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void test2() {
        final int[] nums1 = {1, 2};
        final int[] nums2 = {3, 4};
        assertEquals(2.5, sol.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void test3() {
        final int[] nums1 = {0, 0};
        final int[] nums2 = {0, 0};
        assertEquals(0.0, sol.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void test4() {
        final int[] nums1 = {};
        final int[] nums2 = {1};
        assertEquals(1.0, sol.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void test5() {
        final int[] nums1 = {2};
        final int[] nums2 = {};
        assertEquals(2.0, sol.findMedianSortedArrays(nums1, nums2));
    }
}