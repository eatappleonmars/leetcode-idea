package leetcode.editor.en;

import org.junit.jupiter.api.Test;
import utils.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P863AllNodesDistanceKInBinaryTreeTest {
    P863AllNodesDistanceKInBinaryTree.Solution sol = new P863AllNodesDistanceKInBinaryTree().new Solution();

    @Test
    public void test1() {
        final TreeNode root = new TreeNode(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        final TreeNode target = new TreeNode(5);
        final int k = 2;
        final List<Integer> actual = sol.distanceK(root, target, k);
        final List<Integer> expected = Arrays.asList(7,4,1);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        final TreeNode root = new TreeNode(new Integer[]{1});
        final TreeNode target = new TreeNode(1);
        final int k = 3;
        final List<Integer> actual = sol.distanceK(root, target, k);
        final List<Integer> expected = List.of();
        assertEquals(expected, actual);
    }
}