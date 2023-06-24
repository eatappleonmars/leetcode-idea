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

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> countMap = new HashMap<>();
        countMap.put(0L, 1);
        return helper(root, 0, targetSum, countMap);
    }

    private int helper(TreeNode node, long prefixSum, int target, Map<Long, Integer> countMap) {
        if (node == null) {
            return 0;
        }

        prefixSum += node.val;
        int count = countMap.getOrDefault(prefixSum - target, 0);
        countMap.put(prefixSum, countMap.getOrDefault(prefixSum, 0) + 1);

        count += helper(node.left, prefixSum, target, countMap);
        count += helper(node.right, prefixSum, target, countMap);

        countMap.put(prefixSum, countMap.get(prefixSum) - 1);

        return count;
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