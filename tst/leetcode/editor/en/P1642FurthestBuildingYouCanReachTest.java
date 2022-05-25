package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1642FurthestBuildingYouCanReachTest {

    P1642FurthestBuildingYouCanReach.Solution sol = new P1642FurthestBuildingYouCanReach().new Solution();

    @Test
    public void test1() {
        int[] heights = {1, 3, 4, 5, 6};
        int bricks = 3;
        int ladders = 1;
        assertEquals(4, sol.furthestBuilding(heights, bricks, ladders));
    }

    @Test
    public void test2() {
        int[] heights = {1, 3, 6, 7, 8, 9};
        int bricks = 6;
        int ladders = 1;
        assertEquals(5, sol.furthestBuilding(heights, bricks, ladders));
    }

    @Test
    public void test3() {
        int[] heights = {4, 2, 7, 6, 9, 14, 12};
        int bricks = 5;
        int ladders = 1;
        assertEquals(4, sol.furthestBuilding(heights, bricks, ladders));
    }

    @Test
    public void test4() {
        int[] heights = {4, 12, 2, 7, 3, 18, 20, 3, 19};
        int bricks = 10;
        int ladders = 2;
        assertEquals(7, sol.furthestBuilding(heights, bricks, ladders));
    }
}