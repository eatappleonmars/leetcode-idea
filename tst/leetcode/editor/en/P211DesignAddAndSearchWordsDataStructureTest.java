package leetcode.editor.en;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P211DesignAddAndSearchWordsDataStructureTest {

    P211DesignAddAndSearchWordsDataStructure.WordDictionary sol;

    @BeforeEach
    public void setUp() {
        sol = new P211DesignAddAndSearchWordsDataStructure().new WordDictionary();
    }

    @Test
    public void test1() {
        sol.addWord("bad");
        sol.addWord("dad");
        sol.addWord("mad");
        assertTrue(sol.search("bad"));
        assertTrue(sol.search(".ad"));
        assertTrue(sol.search("b.."));
    }
}