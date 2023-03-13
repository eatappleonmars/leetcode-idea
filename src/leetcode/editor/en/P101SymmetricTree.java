//Given the root of a binary tree, check whether it is a mirror of itself (i.e.,
// symmetric around its center). 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,2,3,4,4,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,null,3,null,3]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Could you solve it both recursively and iteratively? Related 
//Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 9291 👎 231


package leetcode.editor.en;

// 2022-05-02 21:57:39

import utils.TreeNode;

public class P101SymmetricTree {
    
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
        public boolean isSymmetric(TreeNode root) {
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode lt, TreeNode rt) {
            if (lt == rt) {
                return true;
            }
            if (lt == null || rt == null) {
                return false;
            }
            return lt.val == rt.val &&
                    isSymmetric(lt.left, rt.right) &&
                    isSymmetric(lt.right, rt.left);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P101SymmetricTree().new Solution();
    } 
}