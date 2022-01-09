//Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
// 
//
// You can think of the left and right pointers as synonymous to the 
//predecessor and successor pointers in a doubly-linked list. For a circular doubly linked 
//list, the predecessor of the first element is the last element, and the successor 
//of the last element is the first element. 
//
// We want to do the transformation in place. After the transformation, the 
//left pointer of the tree node should point to its predecessor, and the right 
//pointer should point to its successor. You should return the pointer to the smallest 
//element of the linked list. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [4,2,5,1,3]
//
//
//Output: [1,2,3,4,5]
//
//Explanation: The figure below shows the transformed BST. The solid line 
//indicates the successor relationship, while the dashed line means the predecessor 
//relationship.
//
// 
//
// Example 2: 
//
// 
//Input: root = [2,1,3]
//Output: [1,2,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -1000 <= Node.val <= 1000 
// All the values of the tree are unique. 
// 
// Related Topics Linked List Stack Tree Depth-First Search Binary Search Tree 
//Binary Tree Doubly-Linked List 👍 1929 👎 160


package leetcode.editor.en;

// 2022-01-09 11:13:33

import utils.Node;

public class P426ConvertBinarySearchTreeToSortedDoublyLinkedList {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    */

    class Solution {
        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            Node res = root;
            while (res.left != null) {
                res = res.left;
            }
            Node[] pair = new Node[2];
            helper(root, pair);
            pair[0].left = pair[1];
            pair[1].right = pair[0];
            return res;
        }

        private void helper(Node root, Node[] pair) {
            // Left
            Node min = null;
            if (root.left == null) {
                min = root;
            } else {
                helper(root.left, pair);
                min = pair[0];
                root.left = pair[1];
                pair[1].right = root;
            }
            // Right
            Node max = null;
            if (root.right == null) {
                max = root;
            } else {
                helper(root.right, pair);
                max = pair[1];
                root.right = pair[0];
                pair[0].left = root;
            }
            // Report min and max to upper level
            pair[0] = min;
            pair[1] = max;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P426ConvertBinarySearchTreeToSortedDoublyLinkedList().new Solution();
        
    } 
}