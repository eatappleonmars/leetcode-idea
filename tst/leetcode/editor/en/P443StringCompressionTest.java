package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P443StringCompressionTest {

    P443StringCompression.Solution sol = new P443StringCompression().new Solution();

    @Test
    public void test1() {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int len = sol.compress(chars);
        char[] actual = new String(chars, 0, len).toCharArray();
        char[] expect = {'a', '2', 'b', '2', 'c', '3'};
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test2() {
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int len = sol.compress(chars);
        char[] actual = new String(chars, 0, len).toCharArray();
        char[] expect = {'a', 'b', '1', '2'};
        assertArrayEquals(expect, actual);
    }

    @Test
    public void test3() {
        char[] chars = {'a'};
        int len = sol.compress(chars);
        char[] actual = new String(chars, 0, len).toCharArray();
        char[] expect = {'a'};
        assertArrayEquals(expect, actual);
    }
}