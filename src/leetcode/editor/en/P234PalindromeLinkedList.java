//Given the head of a singly linked list, return true if it is a palindrome. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 10⁵]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in O(n) time and O(1) space? Related Topics Linked 
//List Two Pointers Stack Recursion 👍 8684 👎 531


package leetcode.editor.en;

// 2022-04-27 10:46:19

import utils.ListNode;

public class P234PalindromeLinkedList {
    
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
        public boolean isPalindrome(ListNode head) {
            // 1. Cut list into half
            ListNode head2 = cut(head);
            // 2. Reverse 2nd half
            head2 = reverse(head2);

              // 3. Traverse and compare
            while (head2 != null) {
                if (head.val != head2.val) {
                    return false;
                }
                head = head.next;
                head2 = head2.next;
            }
            return true;
        }

        private ListNode cut(ListNode head) {
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;

            ListNode slow = dummyHead, fast = dummyHead;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode res = slow.next;
            slow.next = null;

            return res;
        }

        private ListNode reverse(ListNode head) {
            ListNode dummyHead = new ListNode();
            while (head != null) {
                // dummyHead - first - rest
                // dummyHead - insertNode - first - rest
                ListNode insertNode = head;
                head = head.next;

                insertNode.next = dummyHead.next;
                dummyHead.next = insertNode;
            }
            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P234PalindromeLinkedList().new Solution();
        
    } 
}