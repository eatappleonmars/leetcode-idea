package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P305NumberOfIslandsIiTest {

    P305NumberOfIslandsIi.Solution sol = new P305NumberOfIslandsIi().new Solution();
    
    @Test
    public void test3() {
        int m = 3;
        int n = 3;
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 0}, {2, 2}, {1, 2}, {1, 1}, {0, 1}};
        List<Integer> res = sol.numIslands2(m, n, positions);
        List<Integer> exp = List.of(1, 1, 2, 3, 3, 3, 2, 2, 1, 1);
        assertEquals(exp, res);
    }
}