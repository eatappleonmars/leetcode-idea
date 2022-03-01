package leetcode.editor.en;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class P1123LowestCommonAncestorOfDeepestLeavesTest {

    private P1123LowestCommonAncestorOfDeepestLeaves.Solution sol =
            new P1123LowestCommonAncestorOfDeepestLeaves().new Solution();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode actual = sol.lcaDeepestLeaves(root);
        assertEquals(2, actual.val);
    }
}