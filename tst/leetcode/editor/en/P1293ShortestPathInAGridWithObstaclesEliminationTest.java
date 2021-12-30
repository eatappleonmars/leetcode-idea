package leetcode.editor.en;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1293ShortestPathInAGridWithObstaclesEliminationTest {
    P1293ShortestPathInAGridWithObstaclesElimination.Solution sol;
    
    @BeforeEach
    public void setUp() {
        this.sol = new P1293ShortestPathInAGridWithObstaclesElimination().new Solution();
    }
    
    @Test
    public void test1() {
        final int[][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        final int k = 1;
        assertEquals(6, sol.shortestPath(grid, k));
    }

    @Test
    public void test2() {
        final int[][] grid = {
                {0,1,1},
                {1,1,1},
                {1,0,0}
        };
        final int k = 1;
        assertEquals(-1, sol.shortestPath(grid, k));
    }

    @Test
    public void test3() {
        final int[][] grid = {{0}};
        final int k = 0;
        assertEquals(0, sol.shortestPath(grid, k));
    }

    @Test
    public void test4() {
        final int[][] grid = {
                {0,0},
                {1,0}
        };
        final int k = 0;
        assertEquals(2, sol.shortestPath(grid, k));
    }

    @Test
    public void test5() {
        final int[][] grid = {
                {0,1},
                {1,1}
        };
        final int k = 8;
        assertEquals(2, sol.shortestPath(grid, k));
    }
}