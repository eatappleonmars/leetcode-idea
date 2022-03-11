package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1983WidestPairOfIndicesWithEqualRangeSumTest {

    P1983WidestPairOfIndicesWithEqualRangeSum.Solution sol = new P1983WidestPairOfIndicesWithEqualRangeSum().new Solution();

    @Test
    public void test4() {
        int[] nums1 = {0, 1};
        int[] nums2 = {1, 1};
        assertEquals(1, sol.widestPairOfIndices(nums1, nums2));
    }
}