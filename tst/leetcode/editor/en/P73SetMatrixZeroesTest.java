package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P73SetMatrixZeroesTest {

    P73SetMatrixZeroes.Solution sol = new P73SetMatrixZeroes().new Solution();

    @Test
    public void test2() {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] expect = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        sol.setZeroes(matrix);
        assertArrayEquals(expect, matrix);
    }

    @Test
    public void test3() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {0, 10, 11, 12},
                {13, 14, 15, 0}
        };
        int[][] expect = {
                {0, 0, 3, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        sol.setZeroes(matrix);
        assertArrayEquals(expect, matrix);
    }
}