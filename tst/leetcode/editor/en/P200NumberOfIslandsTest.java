package leetcode.editor.en;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P200NumberOfIslandsTest {

    P200NumberOfIslands.Solution sol;

    @BeforeEach
    public void setUp() {
        sol = new P200NumberOfIslands().new Solution();
    }

    @Test
    public void test1() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        assertEquals(1, sol.numIslands(grid));
    }
}