//Given the root of a binary tree, return all duplicate subtrees. 
//
// For each kind of duplicate subtrees, you only need to return the root node 
//of any one of them. 
//
// Two trees are duplicate if they have the same structure with the same node 
//values. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,null,2,4,null,null,4]
//Output: [[2,4],[4]]
// 
//
// Example 2: 
//
// 
//Input: root = [2,1,1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = [2,2,2,3,null,3,null]
//Output: [[2,3],[3]]
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the tree will be in the range [1, 10^4] 
// -200 <= Node.val <= 200 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 27
//00 👎 274


package leetcode.editor.en;

// 2021-12-07 10:09:10

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P652FindDuplicateSubtrees {
    
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
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> res = new ArrayList<>();
            Map<String, Integer> seen = new HashMap<>();
            helper(root, seen, res);
            return res;
        }

        private String helper(TreeNode root, Map<String, Integer> seen, List<TreeNode> res) {
            if (root == null) {
                return "*";
            }
            String lt = helper(root.left, seen, res);
            String rt = helper(root.right, seen, res);

            // Must separate with ',' or alike to tell different between 1, 11 and 11, 1
            StringBuilder sb = new StringBuilder();
            String curr = sb.append(root.val).append(",").append(lt).append(",").append(rt).toString();

            int updatedCount = seen.getOrDefault(curr, 0) + 1;
            seen.put(curr, updatedCount);
            if (updatedCount == 2) {
                res.add(root);
            }
            return curr;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P652FindDuplicateSubtrees().new Solution();
        
    } 
}