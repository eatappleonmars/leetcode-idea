package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P39CombinationSumTest {

    P39CombinationSum.Solution sol = new P39CombinationSum().new Solution();

    @Test
    public void test1() {
        int[] nums = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = sol.combinationSum(nums, target);
        for (List<Integer> combination : res) {
            System.out.println(combination);
        }
    }
    @Test
    public void test2() {
        int[] nums = {2,3,5};
        int target = 8;
        List<List<Integer>> res = sol.combinationSum(nums, target);
        for (List<Integer> combination : res) {
            System.out.println(combination);
        }
    }
}