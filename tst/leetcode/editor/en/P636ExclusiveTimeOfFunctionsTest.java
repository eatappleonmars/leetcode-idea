package leetcode.editor.en;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class P636ExclusiveTimeOfFunctionsTest {

    private final P636ExclusiveTimeOfFunctions.Solution sol = new P636ExclusiveTimeOfFunctions().new Solution();

    @Test
    public void test1() {
        int n = 2;
        List<String> logs = Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6");
        int[] result = sol.exclusiveTime(n, logs);
        int[] expected = {3, 4};
        assertArrayEquals(expected, result);
    }
}