package leetcode.editor.en;

import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class P2096StepByStepDirectionsFromABinaryTreeNodeToAnotherTest {

    private P2096StepByStepDirectionsFromABinaryTreeNodeToAnother.Solution sol =
            new P2096StepByStepDirectionsFromABinaryTreeNodeToAnother().new Solution();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(new Integer[]{5,1,2,3,null,6,4});
        int startValue = 3;
        int destValue = 6;
        String actual = sol.getDirections(root, startValue, destValue);
        assertEquals("UURL", actual);
    }
}