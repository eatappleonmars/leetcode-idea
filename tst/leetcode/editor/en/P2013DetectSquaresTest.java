package leetcode.editor.en;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P2013DetectSquaresTest {
    P2013DetectSquares.DetectSquares sol;

    @BeforeEach
    public void setUp() {
        this.sol = new P2013DetectSquares().new DetectSquares();
    }

    @Test
    public void test1() {
        this.sol.add(new int[]{3,10});
        this.sol.add(new int[]{11,2});
        this.sol.add(new int[]{3,2});
        assertEquals(1, this.sol.count(new int[]{11,10}));
        assertEquals(0, this.sol.count(new int[]{14,8}));
        this.sol.add(new int[]{11,2});
        assertEquals(2, this.sol.count(new int[]{11,10}));
    }

    @Test
    public void test2() {
        this.sol.add(new int[]{0,0});
        this.sol.add(new int[]{0,1});
        this.sol.add(new int[]{0,1});
        this.sol.add(new int[]{1,0});
        this.sol.add(new int[]{1,0});
        this.sol.add(new int[]{1,0});
        assertEquals(6, this.sol.count(new int[]{1,1}));
    }

    @Test
    public void test3() {
        this.sol.add(new int[]{0,0});
        this.sol.add(new int[]{0,1});
        this.sol.add(new int[]{1,0});
        this.sol.add(new int[]{1,1});
        assertEquals(1, this.sol.count(new int[]{1,1}));
    }

    @Test
    public void test() {
        this.sol.add(new int[]{5,10});
        this.sol.add(new int[]{10,5});
        this.sol.add(new int[]{10,10});
        assertEquals(1, this.sol.count(new int[]{5,5}));
        this.sol.add(new int[]{3,0});
        this.sol.add(new int[]{8,0});
        this.sol.add(new int[]{8,5});
        assertEquals(1, this.sol.count(new int[]{3,5}));
        this.sol.add(new int[]{9,0});
        this.sol.add(new int[]{9,8});
        this.sol.add(new int[]{1,8});
        assertEquals(1, this.sol.count(new int[]{1,0}));
        this.sol.add(new int[]{0,0});
        this.sol.add(new int[]{8,0});
        this.sol.add(new int[]{8,8});
        assertEquals(2, this.sol.count(new int[]{0,8}));
        this.sol.add(new int[]{1,9});
        this.sol.add(new int[]{2,9});
        this.sol.add(new int[]{2,10});
        assertEquals(1, this.sol.count(new int[]{1,10}));
        this.sol.add(new int[]{7,8});
        this.sol.add(new int[]{2,3});
        this.sol.add(new int[]{2,8});
        assertEquals(1, this.sol.count(new int[]{7,3}));
        this.sol.add(new int[]{9,10});
        this.sol.add(new int[]{9,5});
        this.sol.add(new int[]{4,5});
        assertEquals(1, this.sol.count(new int[]{4,10}));
    }
}