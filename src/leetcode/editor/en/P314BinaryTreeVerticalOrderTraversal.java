//Given the root of a binary tree, return the vertical order traversal of its 
//nodes' values. (i.e., from top to bottom, column by column). 
//
// If two nodes are in the same row and column, the order should be from left 
//to right. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[9],[3,15],[20],[7]]
// 
//
// Example 2: 
//
// 
//Input: root = [3,9,8,4,0,1,7]
//Output: [[4],[9],[3,0,1],[8],[7]]
// 
//
// Example 3: 
//
// 
//Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
//Output: [[4],[9,5],[3,0,1],[8,2],[7]]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Hash Table Tree Depth-First Search Breadth-First Search 
//Binary Tree 👍 1980 👎 237


package leetcode.editor.en;

// 2022-01-04 10:48:39

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class P314BinaryTreeVerticalOrderTraversal {
    
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
        
        class Pair {
            TreeNode node;
            int col;
            public Pair(TreeNode node, int col) {
                this.node = node;
                this.col = col;
            }
        }
        
        public List<List<Integer>> verticalOrder(TreeNode root) {

            if (root == null) {
                return new ArrayList<>();
            }

            Queue<Pair> queue = new LinkedList<>();
            Map<Integer, List<Integer>> columnMap = new HashMap<>();

            queue.offer(new Pair(root, 0));
            int minCol = 0;

            while (!queue.isEmpty()) {
                Pair pair = queue.poll();

                int col = pair.col;
                TreeNode node = pair.node;
                
                if (!columnMap.containsKey(col)) {
                    columnMap.put(col, new ArrayList<>());
                    minCol = Math.min(minCol, col);
                }
                columnMap.get(col).add(pair.node.val);

                if (node.left != null) {
                    queue.offer(new Pair(node.left, col - 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, col + 1));
                }
            }

            List<List<Integer>> res = new ArrayList<>(columnMap.size());
            for (int i = minCol; i < columnMap.size() + minCol; i++) {
                res.add(columnMap.get(i));
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P314BinaryTreeVerticalOrderTraversal().new Solution();
        
    } 
}