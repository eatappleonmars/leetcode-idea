//Given the head of a linked list, reverse the nodes of the list k at a time, 
//and return the modified list. 
//
// k is a positive integer and is less than or equal to the length of the 
//linked list. If the number of nodes is not a multiple of k then left-out nodes, in 
//the end, should remain as it is. 
//
// You may not alter the values in the list's nodes, only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
// Follow-up: Can you solve the problem in O(1) extra memory space? 
// Related Topics Linked List Recursion 👍 7025 👎 491


package leetcode.editor.en;

// 2022-05-07 10:19:17

import utils.ListNode;

public class P25ReverseNodesInKGroup {
    
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
        public ListNode reverseKGroup(ListNode head, int k) {

            if (!countK(head, k)) {
                return head;
            }

            ListNode dummyHead = new ListNode();
            ListNode tail = head;
            for (int i = 0; i < k && head != null; i++) {
                // dummy -> null
                // dummy -> currFirst -> null
                // dummy -> head -> currFirst -> null
                ListNode currFirst = dummyHead.next;
                ListNode nextHead = head.next;
                dummyHead.next = head;
                head.next = currFirst;
                head = nextHead;
            }

            tail.next = reverseKGroup(head, k);
            return dummyHead.next;
        }

        private boolean countK(ListNode head, int k) {
            while (head != null && k > 0) {
                head = head.next;
                k--;
            }
            return k == 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P25ReverseNodesInKGroup().new Solution();
        
    } 
}