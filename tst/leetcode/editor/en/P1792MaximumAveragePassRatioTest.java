package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1792MaximumAveragePassRatioTest {

    P1792MaximumAveragePassRatio.Solution sol = new P1792MaximumAveragePassRatio().new Solution();

    @Test
    public void test1() {
        int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents = 2;
        assertEquals(0.7833333333333333, sol.maxAverageRatio(classes, extraStudents));
    }
}