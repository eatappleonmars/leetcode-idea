package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1937MaximumNumberOfPointsWithCostTest {
    P1937MaximumNumberOfPointsWithCost.Solution sol = new P1937MaximumNumberOfPointsWithCost().new Solution();

    @Test
    public void test1() {
        final int[][] points = {
                {1,2,3},
                {1,5,1},
                {3,1,1}
        };
        assertEquals(9, sol.maxPoints(points));
    }

    @Test
    public void test2() {
        final int[][] points = {
                {1,5},
                {2,3},
                {4,2}
        };
        assertEquals(11, sol.maxPoints(points));
    }

    @Test
    public void test3() {
        final int[][] points = {
                {4,1,0,4,0},
                {1,0,4,0,5},
                {1,3,0,4,1},
                {4,4,0,4,0}
        };
        assertEquals(15, sol.maxPoints(points));
    }
}