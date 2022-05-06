//Given an array of integers preorder, which represents the preorder traversal 
//of a BST (i.e., binary search tree), construct the tree and return its root. 
//
// It is guaranteed that there is always possible to find a binary search tree 
//with the given requirements for the given test cases. 
//
// A binary search tree is a binary tree where for every node, any descendant 
//of Node.left has a value strictly less than Node.val, and any descendant of Node.
//right has a value strictly greater than Node.val. 
//
// A preorder traversal of a binary tree displays the value of the node first, 
//then traverses Node.left, then traverses Node.right. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [8,5,1,7,10,12]
//Output: [8,5,10,1,7,null,12]
// 
//
// Example 2: 
//
// 
//Input: preorder = [1,3]
//Output: [1,null,3]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 100 
// 1 <= preorder[i] <= 1000 
// All the values of preorder are unique. 
// 
// Related Topics Array Stack Tree Binary Search Tree Monotonic Stack Binary 
//Tree 👍 3626 👎 59


package leetcode.editor.en;

// 2022-05-06 10:38:48

import utils.TreeNode;

public class P1008ConstructBinarySearchTreeFromPreorderTraversal {
    
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

        public TreeNode bstFromPreorder(int[] preorder) {
            return bstFromPreorder(preorder, new int[]{0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode bstFromPreorder(int[] preorder, int[] index, int min, int max) {
            int i = index[0];
            if (i >= preorder.length || preorder[i] <= min || preorder[i] >= max) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[i]);
            index[0]++;
            root.left = bstFromPreorder(preorder, index, min, preorder[i]);
            root.right = bstFromPreorder(preorder, index, preorder[i], max);
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1008ConstructBinarySearchTreeFromPreorderTraversal().new Solution();
        
    } 
}