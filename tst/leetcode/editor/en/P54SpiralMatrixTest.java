package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P54SpiralMatrixTest {

    P54SpiralMatrix.Solution sol = new P54SpiralMatrix().new Solution();

    @Test
    public void test1() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> actual = sol.spiralOrder(matrix);
        List<Integer> expect = List.of(1, 2, 3, 6, 9, 8, 7, 4, 5);
        assertEquals(expect, actual);
    }
}