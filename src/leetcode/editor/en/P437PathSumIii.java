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
        // { prefixSum : count }
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        return dfs(root, 0, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode root, int prefixSum, int targetSum, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        prefixSum += root.val;

        int count = map.getOrDefault(prefixSum - targetSum, 0);
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        count += dfs(root.left, prefixSum, targetSum, map);
        count += dfs(root.right, prefixSum, targetSum, map);

        map.put(prefixSum, map.get(prefixSum) - 1); // backtrack

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