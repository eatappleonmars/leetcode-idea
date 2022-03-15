package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P417PacificAtlanticWaterFlowTest {

    P417PacificAtlanticWaterFlow.Solution sol = new P417PacificAtlanticWaterFlow().new Solution();

    @Test
    public void test2() {
        int[][] heights = {{2, 1}, {1, 2}};
        List<List<Integer>> res = sol.pacificAtlantic(heights);
        System.out.println("test2: " + res);
        assertEquals(4, res.size());
    }
}