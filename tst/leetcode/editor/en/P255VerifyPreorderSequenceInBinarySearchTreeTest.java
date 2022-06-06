package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P255VerifyPreorderSequenceInBinarySearchTreeTest {

    P255VerifyPreorderSequenceInBinarySearchTree.Solution sol =
            new P255VerifyPreorderSequenceInBinarySearchTree().new Solution();

    @Test
    public void test1() {
        int[] preorder = {5, 2, 1, 3, 6};
        assertTrue(sol.verifyPreorder(preorder));
    }

    @Test
    public void test2() {
        int[] preorder = {5, 2, 6, 1, 3};
        assertFalse(sol.verifyPreorder(preorder));
    }
}