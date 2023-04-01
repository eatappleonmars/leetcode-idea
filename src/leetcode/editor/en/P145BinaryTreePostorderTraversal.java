//Given the root of a binary tree, return the postorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,2,3]
//Output: [3,2,1]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Recursive solution is trivial, could you do it iteratively?
//
// Related Topics Stack Tree Depth-First Search Binary Tree 👍 5769 👎 169


package leetcode.editor.en;

// 2023-04-01 11:38:03

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P145BinaryTreePostorderTraversal {
    
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
        public List<Integer> postorderTraversal(TreeNode root) {
//            return solveWithRecursion(root);
            return solveWithIteration(root);
        }

        private List<Integer> solveWithRecursion(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            solveWithRecursionImpl(root, res);
            return res;
        }

        private void solveWithRecursionImpl(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            solveWithRecursionImpl(root.left, res);
            solveWithRecursionImpl(root.right, res);
            res.add(root.val);
        }

        private List<Integer> solveWithIteration(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.offerLast(root);
            solveWithIterationImpl(stack, res);
            return res;
        }

        // Reversed post-order traversal == In-order traversal
        private void solveWithIterationImpl(LinkedList<TreeNode> stack, LinkedList<Integer> res) {
            while (!stack.isEmpty()) {
                TreeNode node = stack.pollLast();
                res.addFirst(node.val);
                if (node.left != null) {
                    stack.offerLast(node.left);
                }
                if (node.right != null) {
                    stack.offerLast(node.right);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P145BinaryTreePostorderTraversal().new Solution();
        
    } 
}