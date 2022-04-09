package leetcode.editor.en;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P432AllOoneDataStructureTest {

    P432AllOoneDataStructure.AllOne allOne;

    @BeforeEach
    public void setUp() {
        this.allOne = new P432AllOoneDataStructure().new AllOne();
    }

    @Test
    public void test1() {
        this.allOne.inc("hello");
        this.allOne.inc("hello");
        assertEquals("hello", this.allOne.getMaxKey());
        assertEquals("hello", this.allOne.getMinKey());
        this.allOne.inc("leet");
        assertEquals("hello", this.allOne.getMaxKey());
        assertEquals("leet", this.allOne.getMinKey());
    }
    @Test
    public void test2() {
        this.allOne.inc("hello");
        this.allOne.inc("goodbye");
        this.allOne.inc("hello");
        this.allOne.inc("hello");
        assertEquals("hello", this.allOne.getMaxKey());
        this.allOne.inc("leet");
        this.allOne.inc("code");
        this.allOne.inc("leet");
        this.allOne.dec("hello");
        this.allOne.inc("leet");
        this.allOne.inc("code");
        this.allOne.inc("code");
        assertTrue(this.allOne.getMaxKey().equals("leet") || this.allOne.getMaxKey().equals("code"));
    }

    @Test
    public void test3() {
        this.allOne.inc("a");
        this.allOne.inc("b");
        this.allOne.inc("c");
        this.allOne.inc("d");
        this.allOne.inc("a");
        this.allOne.inc("b");
        this.allOne.inc("c");
        this.allOne.inc("d");
        this.allOne.inc("c");
        this.allOne.inc("d");
        this.allOne.inc("d");
        this.allOne.inc("a");
        assertEquals("b", this.allOne.getMinKey());
    }
}