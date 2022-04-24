package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P2242MaximumScoreOfANodeSequenceTest {

    P2242MaximumScoreOfANodeSequence.Solution sol = new P2242MaximumScoreOfANodeSequence().new Solution();

    @Test
    public void test1() {
        int[] scores = {5, 2, 9, 8, 4};
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
        assertEquals(24, sol.maximumScore(scores, edges));
    }

    @Test
    public void test2() {
        int[] scores = {14, 12, 10, 8, 1, 2, 3, 1};
        int[][] edges = {{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 1}, {6, 1}, {7, 1}, {2, 1}};
        assertEquals(44, sol.maximumScore(scores, edges));
    }

    @Test
    public void test3() {
        int[] scores = {21, 4, 17, 2, 21};
        int[][] edges = {{3, 2}, {2, 0}, {0, 4}, {2, 1}, {1, 0}, {1, 3}, {3, 4}};
        assertEquals(63, sol.maximumScore(scores, edges));
    }
}