package leetcode.editor.en;

import org.junit.jupiter.api.Test;
import utils.Node;

import static org.junit.jupiter.api.Assertions.*;

class P426ConvertBinarySearchTreeToSortedDoublyLinkedListTest {
    P426ConvertBinarySearchTreeToSortedDoublyLinkedList.Solution sol =
            new P426ConvertBinarySearchTreeToSortedDoublyLinkedList().new Solution();

    @Test
    public void test1() {
        Node root = buildNode1();
        Node actual = sol.treeToDoublyList(root);
        assertEquals(1, actual.val);
        assertEquals(5, actual.left.val);
        assertEquals(2, actual.right.val);
    }

    private Node buildNode1() {
        Node root =
                new Node(4,
                        new Node(2,
                                new Node(1),
                                new Node(3)),
                        new Node(5));
        return root;
    }
}