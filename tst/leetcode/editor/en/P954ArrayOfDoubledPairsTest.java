package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P954ArrayOfDoubledPairsTest {
    P954ArrayOfDoubledPairs.Solution sol = new P954ArrayOfDoubledPairs().new Solution();

    @Test
    public void test1() {
        int[] arr = {2,1,2,6};
        assertFalse(sol.canReorderDoubled(arr));
    }

    @Test
    public void test2() {
        int[] arr = {-5, -3};
        assertFalse(sol.canReorderDoubled(arr));
    }

    @Test
    public void test3() {
        int[] arr = {2,1,2,1,1,1,2,2};
        assertTrue(sol.canReorderDoubled(arr));
    }

    @Test
    public void test4() {
        int[] arr = {4,-2,2,-4};
        assertTrue(sol.canReorderDoubled(arr));
    }
}