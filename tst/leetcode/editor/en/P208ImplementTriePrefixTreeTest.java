package leetcode.editor.en;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P208ImplementTriePrefixTreeTest {

    P208ImplementTriePrefixTree.Trie trie;

    @BeforeEach
    public void setUp() {
        trie = new P208ImplementTriePrefixTree().new Trie();
    }

    @Test
    public void test1() {
        trie.insert("abc");
        trie.insert("abd");
        assertTrue(trie.search("abc"));
        assertTrue(trie.startsWith("a"));
    }
}