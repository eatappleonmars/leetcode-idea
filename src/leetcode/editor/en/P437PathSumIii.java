//Given the root of a binary tree and an integer targetSum, return the number 
//of paths where the sum of the values along the path equals targetSum. 
//
// The path does not need to start or end at the root or a leaf, but it must go 
//downwards (i.e., traveling only from parent nodes to child nodes). 
//
// 
// Example 1: 
//
// 
//Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//Output: 3
//Explanation: The paths that sum to 8 are shown.
// 
//
// Example 2: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 1000]. 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
// Related Topics Tree Depth-First Search Binary Tree 👍 6833 👎 349


package leetcode.editor.en;

// 2022-01-12 09:45:01

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class P437PathSumIii {
    
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

    private int res = 0;

    private int targetSum;
    private Map<Integer, Integer> prefixSumMap = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        this.prefixSumMap.put(0, 1);

        preOrder(root, 0);
        return this.res;
    }

    private void preOrder(TreeNode root, int prefixSum) {
        if (root == null) {
            return;
        }

        prefixSum += root.val;
        this.res += prefixSumMap.getOrDefault(prefixSum - targetSum, 0);
        prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);

        preOrder(root.left, prefixSum);
        preOrder(root.right, prefixSum);

        prefixSumMap.put(prefixSum, prefixSumMap.get(prefixSum) - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P437PathSumIii().new Solution();
        
    } 
}