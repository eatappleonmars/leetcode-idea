package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P40CombinationSumIiTest {

    P40CombinationSumIi.Solution sol = new P40CombinationSumIi().new Solution();

    @Test
    public void test5() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        assertEquals(4, sol.combinationSum2(candidates, target).size());
    }
}