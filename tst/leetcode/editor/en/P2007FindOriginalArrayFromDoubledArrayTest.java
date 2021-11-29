package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class P2007FindOriginalArrayFromDoubledArrayTest {

    private P2007FindOriginalArrayFromDoubledArray.Solution sol = new P2007FindOriginalArrayFromDoubledArray().new Solution();

    @Test
    public void test1() {
        final int[] changed = {1,3,4,2,6,8};
        int[] result = sol.findOriginalArray(changed);
        Arrays.sort(result);
        final int[] expected = {1,3,4};
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {
        final int[] changed = {2,1,2,4,2,4};
        int[] result = sol.findOriginalArray(changed);
        Arrays.sort(result);
        final int[] expected = {1,2,2};
        assertArrayEquals(expected, result);
    }

    @Test
    public void test3() {
        final int[] changed = {0,0,0,0};
        int[] result = sol.findOriginalArray(changed);
        Arrays.sort(result);
        final int[] expected = {0,0};
        assertArrayEquals(expected, result);
    }
}