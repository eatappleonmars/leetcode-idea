//Given the root of a binary tree, determine if it is a valid binary search 
//tree (BST). 
//
// A valid BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the 
//node's key. 
// The right subtree of a node contains only nodes with keys greater than the 
//node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 9595
// 👎 881


package leetcode.editor.en;

// 2022-05-02 22:10:20

import utils.TreeNode;

public class P98ValidateBinarySearchTree {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        private boolean seenMin, seenMax;

        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode root, int min, int max) {
            if (root == null) {
                return true;
            }

            // Exclusive range check
            boolean result = root.val > min && root.val < max;
            // Inclusive range exception #1
            if (root.val == Integer.MIN_VALUE) {
                if (seenMin) {
                    return false;
                }
                seenMin = true;
                result = root.val >= min && root.val < max;
            }
            // Inclusive range exception #1
            if (root.val == Integer.MAX_VALUE) {
                if (seenMax) {
                    return false;
                }
                seenMax = true;
                result = root.val > min && root.val <= max;
            }
            // Exclusive range
            return result && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P98ValidateBinarySearchTree().new Solution();
        
    } 
}