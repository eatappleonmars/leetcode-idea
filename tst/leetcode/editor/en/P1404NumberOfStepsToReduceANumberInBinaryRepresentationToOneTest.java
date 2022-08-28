package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1404NumberOfStepsToReduceANumberInBinaryRepresentationToOneTest {

    P1404NumberOfStepsToReduceANumberInBinaryRepresentationToOne.Solution sol =
            new P1404NumberOfStepsToReduceANumberInBinaryRepresentationToOne().new Solution();

    @Test
    public void test1() {
        String s = "1101";
        assertEquals(6, sol.numSteps(s));
    }

    @Test
    public void test2() {
        String s = "10";
        assertEquals(1, sol.numSteps(s));
    }

    @Test
    public void test3() {
        String s = "1";
        assertEquals(0, sol.numSteps(s));
    }
}