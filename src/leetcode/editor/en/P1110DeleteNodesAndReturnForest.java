//Given the root of a binary tree, each node in the tree has a distinct value. 
//
// After deleting all nodes with a value in to_delete, we are left with a 
//forest (a disjoint union of trees). 
//
// Return the roots of the trees in the remaining forest. You may return the 
//result in any order. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
//Output: [[1,2,null,4],[6],[7]]
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,4,null,3], to_delete = [3]
//Output: [[1,2,4]]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the given tree is at most 1000. 
// Each node has a distinct value between 1 and 1000. 
// to_delete.length <= 1000 
// to_delete contains distinct values between 1 and 1000. 
// 
// Related Topics Tree Depth-First Search Binary Tree 👍 2541 👎 73


package leetcode.editor.en;

// 2022-01-10 09:54:54

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P1110DeleteNodesAndReturnForest {
    
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
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> res = new ArrayList<>();
            Set<Integer> toDelete = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());

//            TreeNode node = sol1(root, toDelete, res);
//            if (node != null) {
//                res.add(root);
//            }

//            sol2(root, null, toDelete, res);
            sol3(root, null, toDelete, res);
            return res;
        }

        /**
         * In solution#1, we decide if the current root node should be added to result
         * while processing its parent node, which is equivalent to we decide if adding
         * the LEFT or RIGHT child nodes to result while processing the current root node.
         */
        private TreeNode sol1(TreeNode root, Set<Integer> toDelete, List<TreeNode> res) {
            if (root == null) {
                return null;
            }

            root.left = sol1(root.left, toDelete, res);
            root.right = sol1(root.right, toDelete, res);

            if (toDelete.contains(root.val)) {
                if (root.left != null) res.add(root.left);
                if (root.right != null) res.add(root.right);
                return null;
            }

            return root;
        }

        /**
         * In solution#2, we decide if the current root node should be added to result
         * while processing the root node itself
         */
        private TreeNode sol2(TreeNode root, TreeNode parent, Set<Integer> toDelete, List<TreeNode> res) {
            if (root == null) {
                return null;
            }
            if (toDelete.contains(root.val)) {
                root.left = sol2(root.left, null, toDelete, res);
                root.right = sol2(root.right, null, toDelete, res);
                return null;
            } else { // root node will not be deleted
                if (parent == null) {
                    res.add(root);
                }
                root.left = sol2(root.left, root, toDelete, res);
                root.right = sol2(root.right, root, toDelete, res);
                return root;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1110DeleteNodesAndReturnForest().new Solution();
        
    } 
}