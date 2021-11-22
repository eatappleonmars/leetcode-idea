//Given the root of a binary tree, imagine yourself standing on the right side 
//of it, return the values of the nodes you can see ordered from top to bottom. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,5,null,4]
//Output: [1,3,4]
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,3]
//Output: [1,3]
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
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 52
//81 👎 289


package leetcode.editor.en;

// 2021-11-22 09:24:37

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class P199BinaryTreeRightSideView {
    
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
        public List<Integer> rightSideView(TreeNode root) {
            return levelTraverseSol(root);
        }

        // Level traverse the tree. Not the optimal solution.
        private List<Integer> levelTraverseSol(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            Consumer<TreeNode> addToQueue = (treeNode -> {
                if (treeNode != null) {
                    queue.offer(treeNode);
                }
            });

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    if (i == 0) {
                        result.add(node.val);
                    }
                    addToQueue.accept(node.right);
                    addToQueue.accept(node.left);
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P199BinaryTreeRightSideView().new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        List<Integer> res = sol.rightSideView(root);
        for (int n : res) {
            System.out.println(n);
        }
    } 
}