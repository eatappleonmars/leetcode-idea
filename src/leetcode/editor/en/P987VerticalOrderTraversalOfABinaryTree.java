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
import java.util.List;
import java.util.Map;
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
        // NOTE: ambiguous requirement
        // Clarification:
        // For points in the same column
        // - node on higher level(close to root) goes first
        // - if they also in the same level, order from small to large
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            // { column : { row : [values] } }
            Map<Integer, TreeMap<Integer, List<Integer>>> map = new HashMap<>();
            int[] minCol = {0};
            verticalTraversal(root, 0, 0, minCol, map);

            List<List<Integer>> res = new ArrayList<>();
            for (int col = minCol[0]; col < map.size() + minCol[0]; col++) {
                List<Integer> valuesInSameColumn = new ArrayList<>();
                TreeMap<Integer, List<Integer>> rowToValuesMap = map.get(col);
                for (int row : rowToValuesMap.keySet()) {
                    List<Integer> valuesInSameRow = rowToValuesMap.get(row);
                    Collections.sort(valuesInSameRow);
                    valuesInSameColumn.addAll(valuesInSameRow);
                }
                res.add(valuesInSameColumn);
            }
            return res;
        }

        private void verticalTraversal(TreeNode root, int row, int col, int[] minCol, Map<Integer, TreeMap<Integer, List<Integer>>> map) {
            if (root == null) {
                return;
            }
            minCol[0] = Math.min(minCol[0], col);
            map.computeIfAbsent(col, key -> new TreeMap<>()).computeIfAbsent(row, key -> new ArrayList<>()).add(root.val);
            verticalTraversal(root.left, row + 1, col - 1, minCol, map);
            verticalTraversal(root.right, row + 1, col + 1, minCol, map);
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