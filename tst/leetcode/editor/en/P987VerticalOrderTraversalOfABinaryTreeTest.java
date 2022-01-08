package leetcode.editor.en;

import org.junit.jupiter.api.Test;
import utils.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P987VerticalOrderTraversalOfABinaryTreeTest {
    P987VerticalOrderTraversalOfABinaryTree.Solution sol = new P987VerticalOrderTraversalOfABinaryTree().new Solution();

    @Test
    public void test1() {
        final TreeNode root = new TreeNode(new Integer[]{3,9,20,null,null,15,7});
        List<List<Integer>> actual = sol.verticalTraversal(root);
        List<List<Integer>> expected = List.of(
                List.of(9),
                List.of(3,15),
                List.of(20),
                List.of(7)
        );
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        final TreeNode root = new TreeNode(new Integer[]{3,1,4,0,2,2});
        List<List<Integer>> actual = sol.verticalTraversal(root);
        List<List<Integer>> expected = List.of(
                List.of(0),
                List.of(1),
                List.of(3,2,2),
                List.of(4)
        );
        assertEquals(expected, actual);
    }
}