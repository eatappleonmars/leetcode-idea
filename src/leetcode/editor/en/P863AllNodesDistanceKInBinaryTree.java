//Given the root of a binary tree, the value of a target node target, and an 
//integer k, return an array of the values of all nodes that have a distance k from 
//the target node. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
//Output: [7,4,1]
//Explanation: The nodes that are a distance 2 from the target node (with value 
//5) have values 7, 4, and 1.
// 
//
// Example 2: 
//
// 
//Input: root = [1], target = 1, k = 3
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 500]. 
// 0 <= Node.val <= 500 
// All the values Node.val are unique. 
// target is the value of one of the nodes in the tree. 
// 0 <= k <= 1000 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 52
//94 👎 110


package leetcode.editor.en;

// 2022-01-06 09:24:34

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P863AllNodesDistanceKInBinaryTree {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            // We need two pieces of information:
            // 1. location of the target node
            // 2. given a node, how to trace back to its parent node
            // Two options in general:
            // 1. [implemented below] Create path from root to target
            // 2. Create map { node : parent } of entire tree

            Deque<TreeNode> pathToTarget = new ArrayDeque<>();`
            buildPathToTarget(root, target, pathToTarget);

            List<Integer> res = new ArrayList<>();
            searchDistanceK(pathToTarget, k, res);
            return res;
        }

        /**
         * Build the ancestor path from the root to the target node
         * Q: How to determine that a node is the ancestor of the target node?
         * A: One of its children is the ancestor of the target node, or is the target node itself.
         */
        private boolean buildPathToTarget(TreeNode node, TreeNode target, Deque<TreeNode> pathToTarget) {
            if (node == null) {
                return false;
            }
            if (node.val == target.val || (buildPathToTarget(node.left, target, pathToTarget)
                    || buildPathToTarget(node.right, target, pathToTarget))) {
                pathToTarget.offerFirst(node);
                return true;
            }
            return false;
        }

        private void searchDistanceK(Deque<TreeNode> pathToTarget, int k, List<Integer> res) {
            // Drop ancestor nodes that more than distance-k
            while (pathToTarget.size() > k + 1) {
                pathToTarget.pollFirst();
            }

            // Corner case: first node on path is distance-k away from target
            if (pathToTarget.size() == k + 1) {
                TreeNode node = pathToTarget.pollFirst();
                res.add(node.val);
            }

            // General case: ignore the node on the path but search one of its children (in that
            // one child must be on the path which should be ignored)
            int distance = pathToTarget.size() - 1;
            while (!pathToTarget.isEmpty()) {
                TreeNode node = pathToTarget.pollFirst();

                if (pathToTarget.isEmpty() || node.left != pathToTarget.peekFirst()) {
                    search(node.left, distance+1, k, res);
                }
                if (pathToTarget.isEmpty() || node.right != pathToTarget.peekFirst()) {
                    search(node.right, distance+1, k, res);
                }
                distance--;
            }
        }

        /**
         * Given a node and its distance to the target node, check if the distance is k.
         * If true, then stop at current node, and add its value to the result.
         * If false, then check both of its children nodes.
         */

        private void search(TreeNode node, int distance, int k, List<Integer> res) {
            if (node == null) {
                return;
            }
            if (distance == k) {
                res.add(node.val);
                return;
            }
            search(node.left, distance+1, k, res);
            search(node.right, distance+1, k, res);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        
    } 
}