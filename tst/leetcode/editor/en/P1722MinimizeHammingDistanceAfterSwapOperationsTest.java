package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1722MinimizeHammingDistanceAfterSwapOperationsTest {

    P1722MinimizeHammingDistanceAfterSwapOperations.Solution sol = new P1722MinimizeHammingDistanceAfterSwapOperations().new Solution();

    @Test
    public void test1() {
        int[] source = {1, 2, 3, 4};
        int[] target = {2, 1, 4, 5};
        int[][] allowedSwaps = {{0, 1}, {2, 3}};
        assertEquals(1, sol.minimumHammingDistance(source, target, allowedSwaps));
    }

    @Test
    public void test2() {
        int[] source = {1, 2, 3, 4};
        int[] target = {1, 3, 2, 4};
        int[][] allowedSwaps = {{0, 1}, {2, 3}};
        assertEquals(2, sol.minimumHammingDistance(source, target, allowedSwaps));
    }

    @Test
    public void test3() {
        int[] source = {5, 1, 2, 4, 3};
        int[] target = {1, 5, 4, 2, 3};
        int[][] allowedSwaps = {{0, 4}, {4, 2}, {1, 3}, {1, 4}};
        assertEquals(0, sol.minimumHammingDistance(source, target, allowedSwaps));
    }
}