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

import java.util.ArrayList;
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
            dfs(root, 0, res);
//            bfs(root, res);
            return res;
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

        private void bfs(TreeNode root, List<List<Integer>> res) {
            Queue<TreeNode> queue = new LinkedList<>();

            boolean forwardOrder = true;
            queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> levelRes = new LinkedList<>();
                int levelSize = queue.size();
                while (levelSize > 0) {
                    TreeNode node = queue.poll();
                    add(node, forwardOrder, levelRes);
                    generate(node, queue);
                    levelSize--;
                }
                forwardOrder = !forwardOrder;
                res.add(levelRes);
            }
        }

        private void add(TreeNode node, boolean forwardOrder, List<Integer> levelRes) {
            if (forwardOrder) {
                levelRes.add(node.val);
            } else {
                levelRes.add(0, node.val);
            }
        }

        private void generate(TreeNode node, Queue<TreeNode> queue) {
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
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