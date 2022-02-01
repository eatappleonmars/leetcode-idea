package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1834SingleThreadedCpuTest {
    P1834SingleThreadedCpu.Solution sol = new P1834SingleThreadedCpu().new Solution();

    @Test
    public void test1() {
        final int[][] tasks = {{1,2},{2,4},{3,2},{4,1}};
        final int[] actual = sol.getOrder(tasks);
        final int[] expected = {0,2,3,1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        final int[][] tasks = {{7,10},{7,12},{7,5},{7,4},{7,2}};
        final int[] actual = sol.getOrder(tasks);
        final int[] expected = {4,3,2,0,1};
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void test3() {
        final int[][] tasks = {{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}};
        final int[] actual = sol.getOrder(tasks);
        final int[] expected = {6,1,2,9,4,10,0,11,5,13,3,8,12,7};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test4() {
        final int[][] tasks = {{5,2},{7,2},{9,4},{6,3},{5,10},{1,1}};
        final int[] actual = sol.getOrder(tasks);
        final int[] expected = {5,0,1,3,2,4};
        assertArrayEquals(expected, actual);
    }
}