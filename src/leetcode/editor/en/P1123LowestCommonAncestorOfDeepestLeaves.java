//Given the root of a binary tree, return the lowest common ancestor of its 
//deepest leaves. 
//
// Recall that: 
//
// 
// The node of a binary tree is a leaf if and only if it has no children 
// The depth of the root of the tree is 0. if the depth of a node is d, the 
//depth of each of its children is d + 1. 
// The lowest common ancestor of a set S of nodes, is the node A with the 
//largest depth such that every node in S is in the subtree with root A. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4]
//Output: [2,7,4]
//Explanation: We return the node with value 2, colored in yellow in the 
//diagram.
//The nodes coloured in blue are the deepest leaf-nodes of the tree.
//Note that nodes 6, 0, and 8 are also leaf nodes, but the depth of them is 2, 
//but the depth of nodes 7 and 4 is 3. 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [1]
//Explanation: The root is the deepest node in the tree, and it's the lca of 
//itself.
// 
//
// Example 3: 
//
// 
//Input: root = [0,1,3,null,2]
//Output: [2]
//Explanation: The deepest leaf node in the tree is 2, the lca of one node is 
//itself.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree will be in the range [1, 1000]. 
// 0 <= Node.val <= 1000 
// The values of the nodes in the tree are unique. 
// 
//
// 
// Note: This question is the same as 865: https://leetcode.com/problems/
//smallest-subtree-with-all-the-deepest-nodes/ 
// Related Topics Hash Table Tree Depth-First Search Breadth-First Search 
//Binary Tree 👍 1105 👎 729


package leetcode.editor.en;

// 2022-03-01 14:41:23

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P1123LowestCommonAncestorOfDeepestLeaves {
    
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
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            DeepestLeaves deepestLeaves = new DeepestLeaves();
            findDeepestNodes(root, 0, deepestLeaves);
            return lca(root, deepestLeaves);
        }

        class DeepestLeaves {

            private int depth = 0;
            private Set<Integer> leaves = new HashSet<>();

            public void update(TreeNode node, int depth) {
                if (this.depth > depth) {
                    return;
                }
                if (this.depth < depth) {
                    this.depth = depth;
                    this.leaves.clear();
                }
                this.leaves.add(node.val);
            }

            public boolean contains(TreeNode node) {
                return this.leaves.contains(node.val);
            }
        }

        private void findDeepestNodes(TreeNode root, int depth, DeepestLeaves deepestLeaves) {
            if (root.left == null && root.right == null) {
                deepestLeaves.update(root, depth);
                return;
            }
            if (root.left != null) {
                findDeepestNodes(root.left, depth + 1, deepestLeaves);
            }
            if (root.right != null) {
                findDeepestNodes(root.right, depth + 1, deepestLeaves);
            }
        }

        private TreeNode lca(TreeNode root, DeepestLeaves deepestLeaves) {
            if (root == null || deepestLeaves.contains(root)) {
                return root;
            }
            TreeNode lt = lca(root.left, deepestLeaves);
            TreeNode rt = lca(root.right, deepestLeaves);
            if (lt == null) {
                return rt;
            } else if (rt == null) {
                return lt;
            } else {
                return root;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1123LowestCommonAncestorOfDeepestLeaves().new Solution();
        
    } 
}