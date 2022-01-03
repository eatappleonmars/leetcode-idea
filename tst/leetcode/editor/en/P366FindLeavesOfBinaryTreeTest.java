package leetcode.editor.en;

import org.junit.jupiter.api.Test;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P366FindLeavesOfBinaryTreeTest {
    P366FindLeavesOfBinaryTree.Solution sol = new P366FindLeavesOfBinaryTree().new Solution();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(new Integer[]{1,2,3,4,5});
        List<List<Integer>> actual = sol.findLeaves(root);

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(4,5,3));
        expected.add(Arrays.asList(2));
        expected.add(Arrays.asList(1));

        assertEquals(expected, actual);
    }
}