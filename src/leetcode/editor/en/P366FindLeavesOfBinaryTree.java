//Given the root of a binary tree, collect a tree's nodes as if you were doing 
//this: 
//
// 
// Collect all the leaf nodes. 
// Remove all the leaf nodes. 
// Repeat until the tree is empty. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5]
//Output: [[4,5,3],[2],[1]]
//Explanation:
//[[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers 
//since per each level it does not matter the order on which elements are returned.
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 100]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Binary Tree 👍 1765 👎 31


package leetcode.editor.en;

// 2021-11-28 11:15:52

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P366FindLeavesOfBinaryTree {
    
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
        public List<List<Integer>> findLeaves(TreeNode root) {
           List<List<Integer>> result = new ArrayList<>();
           dfs(root, result);
           return result;
        }

        private int dfs(TreeNode root, List<List<Integer>> result) {
            if (root == null) {
                return -1;
            }
            int lt = dfs(root.left, result);
            int rt = dfs(root.right, result);

            // "index" is the index into which root value is stored in result
            // also indicates its largest distance to the leaves
            int index = Math.max(lt, rt) + 1;
            if (index == result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(index).add(root.val);

            return index;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P366FindLeavesOfBinaryTree().new Solution();
        
    } 
}