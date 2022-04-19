package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P313SuperUglyNumberTest {

    P313SuperUglyNumber.Solution sol = new P313SuperUglyNumber().new Solution();

    @Test
    public void test1() {
        int n = 12;
        int[] primes = {2,7,13,19};
        assertEquals(32, sol.nthSuperUglyNumber(n, primes));
    }
}