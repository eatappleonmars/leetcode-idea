package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P78SubsetsTest {

    P78Subsets.Solution sol = new P78Subsets().new Solution();

    @Test
    public void test3() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = sol.subsets(nums);
        for (List<Integer> subset : res) {
            for (int n : subset) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}