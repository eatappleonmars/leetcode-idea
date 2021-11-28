package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1146SnapshotArrayTest {

    private P1146SnapshotArray.SnapshotArray sol;

    @Test
    public void test1() {
        final int length = 1;
        sol = new P1146SnapshotArray().new SnapshotArray(length);
        sol.set(0, 4);
        sol.set(0, 16);
        sol.set(0, 13);
        sol.snap();
        assertEquals(13, sol.get(0, 0));
    }

    @Test
    public void test2() {
        final int length = 4;
        sol = new P1146SnapshotArray().new SnapshotArray(length);
        sol.snap();
        sol.snap();
        assertEquals(0,sol.get(3, 1));
        sol.set(2, 4);
        sol.snap();
        sol.set(1, 16);
    }
}