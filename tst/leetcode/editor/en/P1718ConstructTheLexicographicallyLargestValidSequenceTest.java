package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class P1718ConstructTheLexicographicallyLargestValidSequenceTest {

    P1718ConstructTheLexicographicallyLargestValidSequence.Solution sol =
            new P1718ConstructTheLexicographicallyLargestValidSequence().new Solution();

    @Test
    public void test1() {
        int n = 1;
        int[] actual = sol.constructDistancedSequence(n);
        int[] expect = {1};
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test2() {
        int n = 2;
        int[] actual = sol.constructDistancedSequence(n);
        int[] expect = {2, 1, 2};
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test3() {
        int n = 3;
        int[] actual = sol.constructDistancedSequence(n);
        int[] expect = {3, 1, 2, 3, 2};
        System.out.println("Test-3: " + Arrays.toString(actual));
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test4() {
        int n = 4;
        int[] actual = sol.constructDistancedSequence(n);
        System.out.println("Test-4: " + Arrays.toString(actual));
        int[] expect = {4, 2, 3, 2, 4, 3, 1};
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test5() {
        int n = 5;
        int[] actual = sol.constructDistancedSequence(n);
        System.out.println("Test-5: " + Arrays.toString(actual));
        int[] expect = {5, 3, 1, 4, 3, 5, 2, 4, 2};
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test6() {
        int n = 6;
        int[] actual = sol.constructDistancedSequence(n);
        System.out.println("Test-6: " + Arrays.toString(actual));
        int[] expect = {6, 4, 2, 5, 2, 4, 6, 3, 5, 1, 3};
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test7() {
        int n = 7;
        int[] actual = sol.constructDistancedSequence(n);
        System.out.println("Test-7: " + Arrays.toString(actual));
        int[] expect = {7, 5, 3, 6, 4, 3, 5, 7, 4, 6, 2, 1, 2};
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test13() {
        int n = 13;
        int[] actual = sol.constructDistancedSequence(n);
        System.out.println("Test-13: " + Arrays.toString(actual));
        int[] expect = {13, 11, 12, 8, 6, 4, 9, 10, 1, 4, 6, 8, 11, 13, 12, 9, 7, 10, 3, 5, 2, 3, 2, 7, 5};
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test14() {
        int n = 14;
        int[] actual = sol.constructDistancedSequence(n);
        System.out.println("Test-14: " + Arrays.toString(actual));
        int[] expect = {14, 12, 13, 9, 7, 11, 4, 1, 10, 8, 4, 7, 9, 12, 14, 13, 11, 8, 10, 6, 3, 5, 2, 3, 2, 6, 5};
        assertArrayEquals(expect, actual);
    }
}