package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P134GasStationTest {

    P134GasStation.Solution sol = new P134GasStation().new Solution();

    @Test
    public void test1() {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        assertEquals(3, sol.canCompleteCircuit(gas, cost));
    }

    @Test
    public void test2() {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        assertEquals(-1, sol.canCompleteCircuit(gas, cost));
    }
}