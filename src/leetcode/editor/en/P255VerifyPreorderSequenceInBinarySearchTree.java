//Given an array of unique integers preorder, return true if it is the correct 
//preorder traversal sequence of a binary search tree. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [5,2,1,3,6]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: preorder = [5,2,6,1,3]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 10⁴ 
// 1 <= preorder[i] <= 10⁴ 
// All the elements of preorder are unique. 
// 
//
// 
// Follow up: Could you do it using only constant space complexity? 
// Related Topics Stack Tree Binary Search Tree Recursion Monotonic Stack 
//Binary Tree 👍 941 👎 71


package leetcode.editor.en;

// 2022-06-03 11:42:04

public class P255VerifyPreorderSequenceInBinarySearchTree {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPreorder(int[] preorder) {
            int endIndex = helper(0, preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
            return endIndex == preorder.length;
        }

        // Return the next index which will be processed by the following executions (in other words, not processed yet)
        private int helper(int index, int[] preorder, int min, int max) {
            if (index == preorder.length) {
                return index;
            }
            if (preorder[index] < min || preorder[index] > max) {
                return index;
            }
            int validRootValue = preorder[index];
            int ltEndIndex = helper(index+1, preorder, min, validRootValue);
            int rtEndIndex = helper(ltEndIndex, preorder, validRootValue, max);
            return rtEndIndex;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P255VerifyPreorderSequenceInBinarySearchTree().new Solution();
        
    } 
}