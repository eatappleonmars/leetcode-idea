package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P131PalindromePartitioningTest {

    P131PalindromePartitioning.Solution sol = new P131PalindromePartitioning().new Solution();

    @Test
    public void test1() {
        String s = "aab";
        assertEquals(2, sol.partition(s).size());
    }
}