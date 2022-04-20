package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P221MaximalSquareTest {

    P221MaximalSquare.Solution sol = new P221MaximalSquare().new Solution();
    
    @Test
    public void test1() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        assertEquals(4, sol.maximalSquare(matrix));
    }

    @Test
    public void test2() {
        char[][] matrix = {
                {'0'}
        };
        assertEquals(0, sol.maximalSquare(matrix));
    }

    @Test
    public void test3() {
        char[][] matrix = {
                {'0', '1'},
                {'1', '0'}
        };
        assertEquals(1, sol.maximalSquare(matrix));
    }
}