package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P399EvaluateDivisionTest {

    P399EvaluateDivision.Solution sol = new P399EvaluateDivision().new Solution();

    @Test
    public void test1() {
        List<List<String>> equations = List.of(
                List.of("a", "b"),
                List.of("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = List.of(
                List.of("a", "c"),
                List.of("b", "a"),
                List.of("a", "e"),
                List.of("a", "a"),
                List.of("x", "x")
        );

        double[] expect = {6.00000, 0.50000, -1.00000, 1.00000, -1.00000};
        double[] actual = sol.calcEquation(equations, values, queries);
        assertArrayEquals(expect, actual);
    }
}