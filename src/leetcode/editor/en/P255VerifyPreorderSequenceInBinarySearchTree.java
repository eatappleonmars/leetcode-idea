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
            return verifyPreorder(preorder, new int[]{0}, 1, 10000);
        }

        // Valid range: [min, max]
        private boolean verifyPreorder(int[] preorder, int[] index, int min, int max) {
            if (index[0] == preorder.length) {
                return true;
            }
            // Verify current value as root value. Increment index if valid.
            int val = preorder[index[0]];
            if (val < min || val > max) {
                return false;
            }
            index[0]++;

            boolean lt = verifyPreorder(preorder, index, min, val - 1);
            boolean rt = verifyPreorder(preorder, index, val + 1, max);

            return lt || rt;
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