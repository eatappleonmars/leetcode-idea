package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1155NumberOfDiceRollsWithTargetSumTest {

    P1155NumberOfDiceRollsWithTargetSum.Solution sol = new P1155NumberOfDiceRollsWithTargetSum().new Solution();

    @Test
    public void test1() {
        int n = 1;
        int k = 6;
        int target = 3;
        assertEquals(1, sol.numRollsToTarget(n, k, target));
    }

    @Test
    public void test2() {
        int n = 2;
        int k = 6;
        int target = 7;
        assertEquals(6, sol.numRollsToTarget(n, k, target));
    }

    @Test
    public void test3() {
        int n = 2;
        int k = 6;
        int target = 10;
        assertEquals(3, sol.numRollsToTarget(n, k, target));
    }

    @Test
    public void test4() {
        int n = 2;
        int k = 4;
        int target = 4;
        assertEquals(3, sol.numRollsToTarget(n, k, target));
    }

    @Test
    public void test5() {
        int n = 30;
        int k = 30;
        int target = 500;
        assertEquals(222616187, sol.numRollsToTarget(n, k, target));
    }
}