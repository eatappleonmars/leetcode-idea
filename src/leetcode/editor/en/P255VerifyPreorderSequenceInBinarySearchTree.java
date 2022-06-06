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
            int count = verifyPreorder(preorder, 0, 1, 10000);
            return count == preorder.length;
        }

        // Valid range: [min, max]
        // Return verified count including current root
        private int verifyPreorder(int[] preorder, int index, int min, int max) {

            if (index == preorder.length) {
                return 0;
            }

            int val = preorder[index];
            if (val < min || val > max) {
                return 0;
            }

            int count = 1;
            count += verifyPreorder(preorder, index + count, min, val - 1); // left
            count += verifyPreorder(preorder, index + count, val + 1, max); // right

            return count;
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