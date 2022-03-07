package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P974SubarraySumsDivisibleByKTest {

    private P974SubarraySumsDivisibleByK.Solution sol = new P974SubarraySumsDivisibleByK().new Solution();

    @Test
    public void test1() {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        assertEquals(7, sol.subarraysDivByK(nums, k));
    }
}