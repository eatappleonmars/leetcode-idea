//Given the root of a binary tree and two integers p and q, return the distance 
//between the nodes of value p and value q in the tree. 
//
// The distance between two nodes is the number of edges on the path from one 
//to the other. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 0
//Output: 3
//Explanation: There are 3 edges between 5 and 0: 5-3-1-0. 
//
// Example 2: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 7
//Output: 2
//Explanation: There are 2 edges between 5 and 7: 5-2-7. 
//
// Example 3: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 5
//Output: 0
//Explanation: The distance between a node and itself is 0. 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// 0 <= Node.val <= 10⁹ 
// All Node.val are unique. 
// p and q are values in the tree. 
// 
// Related Topics Hash Table Tree Depth-First Search Breadth-First Search 
//Binary Tree 👍 210 👎 9


package leetcode.editor.en;

// 2022-03-02 09:30:22

import utils.TreeNode;

public class P1740FindDistanceInABinaryTree {
    
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

        private int res = 0;

        public int findDistance(TreeNode root, int p, int q) {
//            return solutionWithSingleTraverse(root, p, q);
            return solutionWithMultipleTraverse(root, p, q);
        }

        /**
         * Multiple pass
         * 1. Find LCA first
         * 2. Count from LCA to p and q
         */
        private int solutionWithMultipleTraverse(TreeNode root, int p, int q) {
            TreeNode lca = findLCA(root, p, q);
            return countPath(lca, p) + countPath(lca, q);
        }

        private TreeNode findLCA(TreeNode root, int p, int q) {
            if (root == null || p == root.val || q == root.val) {
                return root;
            }
            TreeNode lt = findLCA(root.left, p, q);
            TreeNode rt = findLCA(root.right, p, q);

            if (lt != null && rt != null) {
                return root;
            }
            return lt == null ? rt : lt;
        }

        private int countPath(TreeNode root, int target) {
            if (root == null) {
                return -1;
            }
            if (target == root.val) {
                return 0;
            }
            int count = countPath(root.left, target);
            if (count < 0) {
                count = countPath(root.right, target);
            }
            return count < 0 ? count : count + 1;
        }

        /**
         * Single pass
         * Update this.res as long as criteria is met
         */
        private int solutionWithSingleTraverse(TreeNode root, int p, int q) {
            lcaHelperWithSingleTraverse(root, p, q);
            return this.res;
        }

        private int lcaHelperWithSingleTraverse(TreeNode root, int p, int q) {
            if (root == null) {
                return 0;
            }
            int lt = lcaHelperWithSingleTraverse(root.left, p, q);
            int rt = lcaHelperWithSingleTraverse(root.right, p, q);

            if (p == root.val || q == root.val) {
                if (lt + rt > 0) {
                    this.res = lt + rt;
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (lt > 0 && rt > 0) {
                    this.res = lt + rt;
                    return 0;
                } else if (lt > 0 || rt > 0){
                    return lt + rt + 1;
                } else {
                    return 0;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1740FindDistanceInABinaryTree().new Solution();
        
    } 
}