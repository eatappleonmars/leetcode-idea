package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P46PermutationsTest {

    P46Permutations.Solution sol = new P46Permutations().new Solution();

    @Test
    public void test1() {
        int[] nums = {1};
        List<List<Integer>> res = sol.permute(nums);
        assertEquals(1, res.size());
    }

    @Test
    public void test2() {
        int[] nums = {1,2};
        List<List<Integer>> res = sol.permute(nums);
        assertEquals(2, res.size());
        assertTrue(res.contains(List.of(1,2)));
        assertTrue(res.contains(List.of(2,1)));
    }

    @Test
    public void test3() {
        int[] nums = {1,2,3};
        List<List<Integer>> res = sol.permute(nums);
        assertEquals(6, res.size());
        assertTrue(res.contains(List.of(1,2,3)));
        assertTrue(res.contains(List.of(1,3,2)));
        assertTrue(res.contains(List.of(2,1,3)));
        assertTrue(res.contains(List.of(2,3,1)));
        assertTrue(res.contains(List.of(3,1,2)));
        assertTrue(res.contains(List.of(3,2,1)));
    }
}