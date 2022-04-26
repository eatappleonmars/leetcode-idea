//You are given the head of a singly linked-list. The list can be represented 
//as: 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// Reorder the list to be on the following form: 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// 
//
// You may not modify the values in the list's nodes. Only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4]
//Output: [1,4,2,3]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 5 * 10⁴]. 
// 1 <= Node.val <= 1000 
// 
// Related Topics Linked List Two Pointers Stack Recursion 👍 5736 👎 210


package leetcode.editor.en;

// 2022-04-25 21:36:29

import utils.ListNode;

public class P143ReorderList {
    
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
        public void reorderList(ListNode head) {
            // 1. Cut current list into half
            ListNode head2 = cutIntoHalf(head);
            // 2. Reverse second half
            head2 = reverse(head2);
            // 3. One by one
            reorder(head, head2);
        }

        private void reorder(ListNode head1, ListNode head2) {
            while (head2 != null) {
                ListNode next1 = head1.next;
                ListNode next2 = head2.next;

                head1.next = head2;
                head2.next = next1;

                head1 = next1;
                head2 = next2;
            }
        }

        private ListNode cutIntoHalf(ListNode head) {
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;

            ListNode slow = dummyHead, fast = dummyHead;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode head2 = slow.next;
            slow.next = null;

            return head2;
        }

        private ListNode reverse(ListNode head) {
            ListNode dummyHead = new ListNode();
            while (head != null) {
                // dummyHead -> first -> rest
                // dummyHead -> node -> first -> rest
                ListNode node = head;
                head = head.next;

                ListNode first = dummyHead.next;
                dummyHead.next = node;
                node.next = first;
            }
            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P143ReorderList().new Solution();
        
    } 
}