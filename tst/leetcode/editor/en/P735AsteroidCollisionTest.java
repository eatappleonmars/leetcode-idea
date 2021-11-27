package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P735AsteroidCollisionTest {
    private static final P735AsteroidCollision.Solution sol = new P735AsteroidCollision().new Solution();

    @Test
    public void test1() {
        final int[] asteroids = {5,10,-5};
        final int[] res = sol.asteroidCollision(asteroids);
        final int[] exp = {5, 10};
        assertArrayEquals(exp, res);
    }

    @Test
    public void test2() {
        final int[] asteroids = {8,-8};
        final int[] res = sol.asteroidCollision(asteroids);
        final int[] exp = {};
        assertArrayEquals(exp, res);
    }

    @Test
    public void test3() {
        final int[] asteroids = {10,2,-5};
        final int[] res = sol.asteroidCollision(asteroids);
        final int[] exp = {10};
        assertArrayEquals(exp, res);
    }

    @Test
    public void test4() {
        final int[] asteroids = {-2,-1,1,2};
        final int[] res = sol.asteroidCollision(asteroids);
        final int[] exp = {-2,-1,1,2};
        assertArrayEquals(exp, res);
    }
}