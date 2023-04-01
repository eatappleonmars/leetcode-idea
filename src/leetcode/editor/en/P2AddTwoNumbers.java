//You are given two non-empty linked lists representing two non-negative 
//integers. The digits are stored in reverse order, and each of their nodes contains a 
//single digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the 
//number 0 itself. 
//
// 
// Example 1: 
// 
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have 
//leading zeros. 
// 
//
// Related Topics Linked List Math Recursion 👍 25147 👎 4869


package leetcode.editor.en;

// 2023-04-01 11:05:18

import utils.ListNode;

public class P2AddTwoNumbers {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            final ListNode dummyHead = new ListNode();
            ListNode tail = dummyHead;
            int carry = 0;
            while (l1 != null || l2 != null || carry > 0) {
                int a = 0;
                if (l1 != null) {
                    a = l1.val;
                    l1 = l1.next;
                }
                int b = 0;
                if (l2 != null) {
                    b = l2.val;
                    l2 = l2.next;
                }
                int c = a + b + carry;
                // Compute
                ListNode node = new ListNode (c % 10);
                carry = c / 10;
                // Append to tail
                tail.next = node;
                tail = node;
            }
            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P2AddTwoNumbers().new Solution();
        
    } 
}