package leetcode.editor.en;

import org.junit.jupiter.api.Test;
import utils.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P652FindDuplicateSubtreesTest {
    P652FindDuplicateSubtrees.Solution sol = new P652FindDuplicateSubtrees().new Solution();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(new Integer[]{2,1,11,11,null,1});
        System.out.println(root);
        List<TreeNode> res = sol.findDuplicateSubtrees(root);
        for(TreeNode node : res) {
            System.out.println(res);
        }
    }
}