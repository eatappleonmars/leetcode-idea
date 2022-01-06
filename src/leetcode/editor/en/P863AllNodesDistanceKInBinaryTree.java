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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            Deque<TreeNode> stack = new ArrayDeque<>();
            buildPathFromRootToTarget(stack, root, target);

            Set<Integer> seen = new HashSet<>();
            List<Integer> res = new ArrayList<>();
            int distance = 0;
            while (!stack.isEmpty()) {
                TreeNode node = stack.pollFirst();
                distanceK(node, distance, k, seen, res);
                distance++;
            }
            return res;
        }

        private boolean buildPathFromRootToTarget(Deque<TreeNode> stack, TreeNode node, TreeNode target) {
            if (node == null) {
                return false;
            }
            stack.offerFirst(node);
            if (node.val == target.val) {
                return true;
            }
            boolean found = buildPathFromRootToTarget(stack, node.left, target);
            if (!found) {
                found = buildPathFromRootToTarget(stack, node.right, target);
            }
            if (!found) {
                stack.pollFirst();
            }
            return found;
        }

        private void distanceK(TreeNode node, int distance, int k, Set<Integer> seen, List<Integer> res) {
            if (node == null || distance > k || seen.contains(node.val)) {
                return;
            }
            seen.add(node.val);
            if (distance == k) {
                res.add(node.val);
                return;
            }
            distanceK(node.left, distance + 1, k, seen, res);
            distanceK(node.right, distance + 1, k, seen, res);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P863AllNodesDistanceKInBinaryTree().new Solution();
        
    } 
}