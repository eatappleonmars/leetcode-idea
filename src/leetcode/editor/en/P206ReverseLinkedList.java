//Given the head of a singly linked list, reverse the list, and return the 
//reversed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: [2,1]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is the range [0, 5000]. 
// -5000 <= Node.val <= 5000 
// 
//
// 
// Follow up: A linked list can be reversed either iteratively or recursively. 
//Could you implement both? 
// Related Topics Linked List Recursion 👍 11742 👎 203


package leetcode.editor.en;

// 2022-05-07 09:55:50

import utils.ListNode;

public class P206ReverseLinkedList {
    
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
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
//            return recursiveSolution(head);
            return iterativeSolution(head);
        }

        private ListNode iterativeSolution(ListNode head) {
            ListNode dummyHead = new ListNode();
            while (head != null) {
                // dummy -> null
                // dummy -> currFirst -> null
                // dummy -> head -> currFirst -> null
                ListNode currFirst = dummyHead.next;
                ListNode nextHead = head.next;
                dummyHead.next = head;
                head.next = currFirst;
                head = nextHead;
            }
            return dummyHead.next;
        }

        private ListNode recursiveSolution(ListNode head) {
            if (head.next == null) {
                return head;
            }
            ListNode newHead = recursiveSolution(head.next);
            ListNode tail = head.next;
            tail.next = head;
            head.next = null;
            return newHead;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P206ReverseLinkedList().new Solution();
        
    } 
}