package leetcode.editor.en;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class P297SerializeAndDeserializeBinaryTreeTest {
    P297SerializeAndDeserializeBinaryTree.Codec codec = new P297SerializeAndDeserializeBinaryTree().new Codec();

    private static final TreeNode ROOT_1 = buildRoot1();

    private static final TreeNode ROOT_2 = null;
    private static final String SERIALIZED_STR_2 = "";



    @Nested
    public class PreOrderTests {
        private static final String PREORDER_SERIALIZED_STR_1 = "1,2,*,*,3,4,*,*,5,*,*";

        @Test
        public void test_serialize_1() {
            final String actual = codec.preOrderSerialize(ROOT_1);
            assertEquals(PREORDER_SERIALIZED_STR_1, actual);
        }

        @Test
        public void test_deserialize_1() {
            final TreeNode actual = codec.preOrderDeserialize(PREORDER_SERIALIZED_STR_1);
            assertEquals(ROOT_1, actual);
        }

        @Test
        public void test_serialize_2() {
            final String actual = codec.preOrderSerialize(ROOT_2);
            assertEquals(SERIALIZED_STR_2, actual);
        }

        @Test
        public void test_deserialize_2() {
            final TreeNode actual = codec.preOrderDeserialize(SERIALIZED_STR_2);
            assertEquals(ROOT_2, actual);
        }
    }

    @Nested
    public class BFSTests {
        private static final String BFS_SERIALIZED_STR_1 = "1,2,3,*,*,4,5,";

        @Test
        public void test_serialize_1() {
            final String actual = codec.bfsSerialize(ROOT_1);
            assertEquals(BFS_SERIALIZED_STR_1, actual);
        }

        @Test
        public void test_deserialize_1() {
            final TreeNode actual = codec.bfsDeserialize(BFS_SERIALIZED_STR_1);
            assertEquals(ROOT_1, actual);
        }

        @Test
        public void test_serialize_2() {
            final String actual = codec.bfsSerialize(ROOT_2);
            assertEquals(SERIALIZED_STR_2, actual);
        }

        @Test
        public void test_deserialize_2() {
            final TreeNode actual = codec.bfsDeserialize(SERIALIZED_STR_2);
            assertEquals(ROOT_2, actual);
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