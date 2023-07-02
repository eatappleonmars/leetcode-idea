package leetcode.editor.en;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P380InsertDeleteGetrandomO1Test {


    P380InsertDeleteGetrandomO1.RandomizedSet sol;

    @BeforeEach
    public void setUp() {
        sol = new P380InsertDeleteGetrandomO1().new RandomizedSet();
    }

    @Test
    public void test1() {
        assertTrue(sol.insert(1));
        assertFalse(sol.remove(2));
        assertTrue(sol.insert(2));
//        assertEquals(1, sol.getRandom());
        assertTrue(sol.remove(1));
        assertFalse(sol.insert(2));
        assertEquals(2, sol.getRandom());
    }
}