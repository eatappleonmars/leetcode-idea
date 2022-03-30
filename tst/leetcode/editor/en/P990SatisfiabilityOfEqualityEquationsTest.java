package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P990SatisfiabilityOfEqualityEquationsTest {

    P990SatisfiabilityOfEqualityEquations.Solution sol = new P990SatisfiabilityOfEqualityEquations().new Solution();

    @Test
    public void test3() {
        String[] equations = {"c==c", "b==d", "x!=z" };
        assertTrue(sol.equationsPossible(equations));
    }
}