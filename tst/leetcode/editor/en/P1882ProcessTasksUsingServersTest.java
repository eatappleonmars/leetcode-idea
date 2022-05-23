package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1882ProcessTasksUsingServersTest {

    P1882ProcessTasksUsingServers.Solution sol = new P1882ProcessTasksUsingServers().new Solution();

    @Test
    public void test1() {
        int[] servers = {3, 3, 2};
        int[] tasks = {1, 2, 3, 2, 1, 2};
        int[] expect = {2, 2, 0, 2, 1, 2};
        int[] actual = sol.assignTasks(servers, tasks);
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test3() {
        int[] servers = {10, 63, 95, 16, 85, 57, 83, 95, 6, 29, 71};
        int[] tasks = {70, 31, 83, 15, 32, 67, 98, 65, 56, 48, 38, 90, 5};
        int[] expect = {8, 0, 3, 9, 5, 1, 10, 6, 4, 2, 7, 9, 0};
        int[] actual = sol.assignTasks(servers, tasks);
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test4() {
        int[] servers = {31, 96, 73, 90, 15, 11, 1, 90, 72, 9, 30, 88};
        int[] tasks = {87, 10, 3, 5, 76, 74, 38, 64, 16, 64, 93, 95, 60, 79, 54, 26, 30, 44, 64, 71};
        int[] expect = {6, 9, 5, 4, 10, 5, 0, 8, 4, 2, 11, 9, 3, 7, 1, 4, 0, 4, 1, 8};
        int[] actual = sol.assignTasks(servers, tasks);
        assertArrayEquals(expect, actual);
    }
}