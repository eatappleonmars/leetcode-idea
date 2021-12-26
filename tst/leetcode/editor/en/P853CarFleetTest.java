package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P853CarFleetTest {
    P853CarFleet.Solution sol = new P853CarFleet().new Solution();

    @Test
    public void test1() {
        final int target = 12;
        final int[] position = {10,8,0,5,3};
        final int[] speed = {2,4,1,1,3};
        assertEquals(3, sol.carFleet(target, position, speed));
    }
}