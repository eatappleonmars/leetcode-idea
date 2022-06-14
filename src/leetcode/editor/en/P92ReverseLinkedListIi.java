//Given the head of a singly linked list and two integers left and right where 
//left <= right, reverse the nodes of the list from position left to position 
//right, and return the reversed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
// 
//
// Example 2: 
//
// 
//Input: head = [5], left = 1, right = 1
//Output: [5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//Follow up: Could you do it in one pass? Related Topics Linked List 👍 6298 👎 
//298


package leetcode.editor.en;

// 2022-06-14 10:05:29

import utils.ListNode;

public class P92ReverseLinkedListIi {
    
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == right) {
                return head;
            }
            // Introduce dummyHead in case first node is involved
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;
            head = dummyHead;
            // Locate head, the node before the first node to be reversed
            for (int i = 0; i < left - 1; i++) {
                head = head.next;
            }
            // Total: right - left + 1 nodes to reverse
            final ListNode tail = head.next; // tail takes 1
            for (int i = 1; i <= right - left; i++) { // remaining (right - left) nodes
                ListNode first = head.next;
                ListNode target = tail.next;
                // Update tail
                tail.next = target.next;
                // Insert target between head and first
                head.next = target;
                target.next = first;
            }
            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P92ReverseLinkedListIi().new Solution();
        
    } 
}