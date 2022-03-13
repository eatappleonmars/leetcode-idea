package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P51NQueensTest {

    P51NQueens.Solution sol = new P51NQueens().new Solution();

    @Test
    public void test1() {
        int n = 1;
        assertEquals(0, sol.solveNQueens(n).size());
    }

    @Test
    public void test2() {
        int n = 2;
        assertEquals(0, sol.solveNQueens(n).size());
    }

    @Test
    public void test3() {
        int n = 3;
        assertEquals(0, sol.solveNQueens(n).size());
    }

    @Test
    public void test4() {
        int n = 4;
        assertEquals(2, sol.solveNQueens(n).size());
    }
}