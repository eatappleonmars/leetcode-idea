package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P815BusRoutesTest {

    P815BusRoutes.Solution sol = new P815BusRoutes().new Solution();

    @Test
    public void test3() {
        int[][] routes = {{2}, {2, 8}};
        int source = 8;
        int target = 2;
        assertEquals(1, sol.numBusesToDestination(routes, source, target));
    }
}