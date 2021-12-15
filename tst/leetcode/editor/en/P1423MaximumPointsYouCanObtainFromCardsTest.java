package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1423MaximumPointsYouCanObtainFromCardsTest {
    P1423MaximumPointsYouCanObtainFromCards.Solution sol = new P1423MaximumPointsYouCanObtainFromCards().new Solution();

    @Test
    public void test1() {
        final int[] cardPoints = {1,79,80,1,1,1,200,1};
        final int k = 3;
        assertEquals(202, sol.maxScore(cardPoints, k));
    }

    @Test
    public void test2() {
        final int[] cardPoints = {96,90,41,82,39,74,64,50,30};
        final int k = 8;
        assertEquals(536, sol.maxScore(cardPoints, k));
    }
}