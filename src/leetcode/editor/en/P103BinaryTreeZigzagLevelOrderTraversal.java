//Given the root of a binary tree, return the zigzag level order traversal of 
//its nodes' values. (i.e., from left to right, then right to left for the next 
//level and alternate between). 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[20,9],[15,7]]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Breadth-First Search Binary Tree 👍 5794 👎 169


package leetcode.editor.en;

// 2022-05-05 09:42:31

import com.sun.source.tree.Tree;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P103BinaryTreeZigzagLevelOrderTraversal {
    
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
        /**
         * Two methods:
         * 1. Traverse tree in level order, and record node values in zip-zag order (implemented below)
         * 2. Traverse tree in zig-zag level order, and record node values accordingly
         */
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }
//            dfs(root, 0, res);
            bfs(root, res);
            return res;
        }

        public void bfs(TreeNode root, List<List<Integer>> res) {

            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offerFirst(root);

            boolean leftToRight = true;

            while (!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> levelValues = new ArrayList<>(size);
                if (leftToRight) {
                    while (size > 0) {
                        TreeNode node = deque.pollFirst();
                        levelValues.add(node.val);
                        if (node.left != null) deque.offerLast(node.left);
                        if (node.right != null) deque.offerLast(node.right);
                        size--;
                    }
                } else {
                    while (size > 0) {
                        TreeNode node = deque.pollLast();
                        levelValues.add(node.val);
                        if (node.right != null) deque.offerFirst(node.right);
                        if (node.left != null) deque.offerFirst(node.left);
                        size--;
                    }
                }
                leftToRight = !leftToRight;
                res.add(levelValues);
            }
        }

        private void dfs(TreeNode root, int depth, List<List<Integer>> res) {
            if (root == null) {
                return;
            }
            if (depth + 1 > res.size()) {
                res.add(new LinkedList<>());
            }
            List<Integer> levelRes = res.get(depth);
            if (depth % 2 == 0) {
                levelRes.add(root.val);
            } else {
                levelRes.add(0, root.val);
            }
            dfs(root.left, depth + 1, res);
            dfs(root.right, depth + 1, res);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
        
    } 
}