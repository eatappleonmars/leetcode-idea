//Given the root of a binary tree, calculate the vertical order traversal of 
//the binary tree. 
//
// For each node at position (row, col), its left and right children will be at 
//positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of 
//the tree is at (0, 0). 
//
// The vertical order traversal of a binary tree is a list of top-to-bottom 
//orderings for each column index starting from the leftmost column and ending on the 
//rightmost column. There may be multiple nodes in the same row and same column. 
//In such a case, sort these nodes by their values. 
//
// Return the vertical order traversal of the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[9],[3,15],[20],[7]]
//Explanation:
//Column -1: Only node 9 is in this column.
//Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
//Column 1: Only node 20 is in this column.
//Column 2: Only node 7 is in this column. 
//
// Example 2: 
//
// 
//Input: root = [1,2,3,4,5,6,7]
//Output: [[4],[2],[1,5,6],[3],[7]]
//Explanation:
//Column -2: Only node 4 is in this column.
//Column -1: Only node 2 is in this column.
//Column 0: Nodes 1, 5, and 6 are in this column.
//          1 is at the top, so it comes first.
//          5 and 6 are at the same position (2, 0), so we order them by their 
//value, 5 before 6.
//Column 1: Only node 3 is in this column.
//Column 2: Only node 7 is in this column.
// 
//
// Example 3: 
//
// 
//Input: root = [1,2,3,4,6,5,7]
//Output: [[4],[2],[1,5,6],[3],[7]]
//Explanation:
//This case is the exact same as example 2, but with nodes 5 and 6 swapped.
//Note that the solution remains the same since 5 and 6 are in the same 
//location and should be ordered by their values.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// 0 <= Node.val <= 1000 
// 
// Related Topics Hash Table Tree Depth-First Search Breadth-First Search 
//Binary Tree 👍 2513 👎 3028


package leetcode.editor.en;

// 2022-01-08 10:14:25

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class P987VerticalOrderTraversalOfABinaryTree {
    
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
        // NOTE: ambiguous requirement in problem description
        // Clarification:
        // For tree nodes in the same column
        // - node with smaller row goes first
        // - for nodes on the same row, node with smaller val goes first

        class NodeInfo {
            int row;
            int val;
            NodeInfo (int r, int v) {
                row = r;
                val = v;
            }
        }

        public List<List<Integer>> verticalTraversal(TreeNode root) {

            // { Sorted column : NodeInfo Priority Queue }
            // Priority Queue sort by row first, then by tree node value
            TreeMap<Integer, Queue<NodeInfo>> map = new TreeMap<>();
            traverse(root, 0, 0, map);
            // Convert to list of list
            List<List<Integer>> res = new ArrayList<>();
            for (Map.Entry<Integer, Queue<NodeInfo>> entry : map.entrySet()) {
                Queue<NodeInfo> nodes = entry.getValue(); // sorted nodes on the same column
                List<Integer> vals = new ArrayList<>();
                while (!nodes.isEmpty()) {
                    vals.add(nodes.poll().val);
                }
                res.add(vals);
            }
            return res;
        }

        private void traverse(TreeNode root, int row, int col, Map<Integer, Queue<NodeInfo>> map) {
            if (root == null) {
                return;
            }
            Queue<NodeInfo> pq = map.computeIfAbsent(col, c -> new PriorityQueue<>((n1, n2) -> {
                if (n1.row == n2.row) {
                    return n1.val - n2.val;
                }
                return n1.row - n2.row;
            }));
            pq.offer(new NodeInfo(row, root.val));

            traverse(root.left, row + 1, col - 1, map);
            traverse(root.right, row + 1, col + 1, map);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P987VerticalOrderTraversalOfABinaryTree().new Solution();
        
    } 
}