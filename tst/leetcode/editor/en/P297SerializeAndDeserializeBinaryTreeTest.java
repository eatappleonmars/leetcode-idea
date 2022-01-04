package leetcode.editor.en;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class P297SerializeAndDeserializeBinaryTreeTest {
    P297SerializeAndDeserializeBinaryTree.Codec codec = new P297SerializeAndDeserializeBinaryTree().new Codec();

    private static final TreeNode ROOT_1 = buildRoot1();
    private static final String ROOT_1_STR = "1,2,3,*,*,4,5,";

    @Nested
    public class SerializationTests {
        @Test
        public void test1() {
            final String actual = codec.serialize(ROOT_1);
            assertEquals(ROOT_1_STR, actual);
        }
    }

    @Nested
    public class DeserializationTests {
        @Test
        public void test1() {
            final TreeNode actual = codec.deserialize(ROOT_1_STR);
            assertEquals(ROOT_1, actual);
        }
    }

    private static TreeNode buildRoot1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        return node1;
    }
}