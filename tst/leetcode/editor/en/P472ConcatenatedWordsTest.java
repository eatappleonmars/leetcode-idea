package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P472ConcatenatedWordsTest {

    P472ConcatenatedWords.Solution sol = new P472ConcatenatedWords().new Solution();

    @Test
    public void test1() {
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        List<String> actual = sol.findAllConcatenatedWordsInADict(words);
        Collections.sort(actual);
        List<String> expect = List.of("catsdogcats", "dogcatsdog", "ratcatdogcat");
        assertEquals(expect, actual);
    }

    @Test
    public void test2() {
        String[] words = {"cat", "dog", "catdog"};
        List<String> actual = sol.findAllConcatenatedWordsInADict(words);
        Collections.sort(actual);
        List<String> expect = List.of("catdog");
        assertEquals(expect, actual);
    }

    @Test
    public void test3() {
        String[] words = {"cat", "dog", "catdog", ""};
        List<String> actual = sol.findAllConcatenatedWordsInADict(words);
        Collections.sort(actual);
        List<String> expect = List.of("catdog");
        assertEquals(expect, actual);
    }
}