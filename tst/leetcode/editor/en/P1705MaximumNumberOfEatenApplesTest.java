package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1705MaximumNumberOfEatenApplesTest {

    P1705MaximumNumberOfEatenApples.Solution sol = new P1705MaximumNumberOfEatenApples().new Solution();

    @Test
    public void test1() {
        int[] apples = {1, 2, 3, 5, 2};
        int[] days = {3, 2, 1, 4, 2};
        assertEquals(7, sol.eatenApples(apples, days));
    }
}