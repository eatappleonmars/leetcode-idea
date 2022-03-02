//Given the root of a binary tree and an array of TreeNode objects nodes, 
//return the lowest common ancestor (LCA) of all the nodes in nodes. All the nodes will 
//exist in the tree, and all values of the tree's nodes are unique. 
//
// Extending the definition of LCA on Wikipedia: "The lowest common ancestor of 
//n nodes p1, p2, ..., pn in a binary tree T is the lowest node that has every pi 
//as a descendant (where we allow a node to be a descendant of itself) for every 
//valid i". A descendant of a node x is a node y that is on the path from node x 
//to some leaf node. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [4,7]
//Output: 2
//Explanation: The lowest common ancestor of nodes 4 and 7 is node 2.
// 
//
// Example 2: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [1]
//Output: 1
//Explanation: The lowest common ancestor of a single node is the node itself.
//
// 
//
// Example 3: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [7,6,2,4]
//Output: 5
//Explanation: The lowest common ancestor of the nodes 7, 6, 2, and 4 is node 5.
//
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -10⁹ <= Node.val <= 10⁹ 
// All Node.val are unique. 
// All nodes[i] will exist in the tree. 
// All nodes[i] are distinct. 
// 
// Related Topics Tree Depth-First Search Binary Tree 👍 262 👎 9


package leetcode.editor.en;

// 2022-03-02 09:08:38

import utils.TreeNode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class P1676LowestCommonAncestorOfABinaryTreeIv {
    
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

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
            Set<Integer> targets = Arrays.stream(nodes).map(node -> node.val).collect(Collectors.toSet());
            return lcaHelper(root, targets);
        }

        private TreeNode lcaHelper(TreeNode root, Set<Integer> targets) {
            if (root == null || targets.contains(root.val)) {
                return root;
            }

            TreeNode lt = lcaHelper(root.left, targets);
            TreeNode rt = lcaHelper(root.right, targets);

            if (lt == null) {
                return rt;
            } else if (rt == null) {
                return lt;
            } else {
                return root;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1676LowestCommonAncestorOfABinaryTreeIv().new Solution();
        
    } 
}