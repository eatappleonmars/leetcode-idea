package leetcode.editor.en;

import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class P98ValidateBinarySearchTreeTest {

    P98ValidateBinarySearchTree.Solution sol = new P98ValidateBinarySearchTree().new Solution();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(new Integer[]{2147483647, 2147483647});
        assertFalse(sol.isValidBST(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(new Integer[]{-2147483648, null, 2147483647});
        assertTrue(sol.isValidBST(root));
    }
}