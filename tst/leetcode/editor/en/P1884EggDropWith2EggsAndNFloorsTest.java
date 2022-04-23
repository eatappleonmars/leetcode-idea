package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1884EggDropWith2EggsAndNFloorsTest {

    P1884EggDropWith2EggsAndNFloors.Solution sol = new P1884EggDropWith2EggsAndNFloors().new Solution();

    @Test
    public void test1() {
        assertEquals(1, sol.twoEggDrop(1));
    }

    @Test
    public void test2() {
        assertEquals(2, sol.twoEggDrop(2));
    }

    @Test
    public void test3() {
        assertEquals(2, sol.twoEggDrop(3));
    }

    @Test
    public void test4() {
        assertEquals(3, sol.twoEggDrop(4));
    }

    @Test
    public void test5() {
        assertEquals(3, sol.twoEggDrop(5));
    }

    @Test
    public void test6() {
        assertEquals(3, sol.twoEggDrop(6));
    }

    @Test
    public void test7() {
        assertEquals(4, sol.twoEggDrop(7));
    }


}