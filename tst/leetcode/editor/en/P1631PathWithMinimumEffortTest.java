package leetcode.editor.en;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1631PathWithMinimumEffortTest {

    P1631PathWithMinimumEffort.Solution sol;

    @BeforeEach
    public void setUp() {
        this.sol = new P1631PathWithMinimumEffort().new Solution();
    }

    @Test
    public void test1() {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        assertEquals(2, sol.minimumEffortPath(heights));
    }
    @Test
    public void test2() {
        int[][] heights = {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
        assertEquals(1, sol.minimumEffortPath(heights));
    }

    @Test
    public void test3() {
        int[][] heights = {{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
        assertEquals(0, sol.minimumEffortPath(heights));
    }

}