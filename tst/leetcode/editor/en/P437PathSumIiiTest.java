package leetcode.editor.en;

import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class P437PathSumIiiTest {
    P437PathSumIii.Solution sol = new P437PathSumIii().new Solution();

    @Test
    public void test1() {
        final TreeNode root = new TreeNode(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        final int targetSum = 8;
        assertEquals(3, sol.pathSum(root, targetSum));
    }

    @Test
    public void test2() {
        final TreeNode root = new TreeNode(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        final int targetSum = 22;
        assertEquals(3, sol.pathSum(root, targetSum));
    }

    @Test
    public void test3() {
        final TreeNode root = new TreeNode(new Integer[]{1,2,3});
        final int targetSum = 0;
        assertEquals(0, sol.pathSum(root, targetSum));
    }

    @Test
    public void test4() {
        final TreeNode root = new TreeNode(new Integer[]{0,1,1});
        final int targetSum = 1;
        assertEquals(4, sol.pathSum(root, targetSum));
    }

    // The prefix sum overflows if using int
    @Test
    public void test5() {
        final TreeNode root = new TreeNode(new Integer[]{1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000});
        final int targetSum = 0;
        assertEquals(0, sol.pathSum(root, targetSum));
    }
}