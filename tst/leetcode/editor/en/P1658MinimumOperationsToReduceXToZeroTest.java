package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1658MinimumOperationsToReduceXToZeroTest {

    P1658MinimumOperationsToReduceXToZero.Solution sol = new P1658MinimumOperationsToReduceXToZero().new Solution();

    @Test
    public void test4() {
        int[] nums = {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309};
        int x = 134365;
        assertEquals(16, sol.minOperations(nums, x));
    }
}