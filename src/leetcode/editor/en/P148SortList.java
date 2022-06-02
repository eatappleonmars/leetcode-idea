//Given the head of a linked list, return the list after sorting it in 
//ascending order. 
//
// 
// Example 1: 
//
// 
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
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
// The number of nodes in the list is in the range [0, 5 * 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)? 
// Related Topics Linked List Two Pointers Divide and Conquer Sorting Merge 
//Sort 👍 7210 👎 235


package leetcode.editor.en;

// 2022-06-02 09:42:41

import utils.ListNode;

public class P148SortList {
    
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
        public ListNode sortList(ListNode head) {
            return recursiveMergeSort(head);
        }

        /**
         * Time Complexity: O(n*Log(n))
         * Space Complexity: O(1)
         */
//        private ListNode iterativeMergeSort(ListNode head) {}


        /**
         * Time Complexity: O(n*Log(n))
         * Space Complexity: O(Log(n)) due to recursion
         */
        private ListNode recursiveMergeSort(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode middleHead = cut(head);
            head = recursiveMergeSort(head);
            middleHead = recursiveMergeSort(middleHead);
            return merge(head, middleHead);
        }


        // Case: 1 -> 2 -> null | Result: 1 -> null, 2 -> null
        // Case: 1 -> 2 -> 3 -> null | Result: 1 -> 2 -> null, 3 -> null
        private ListNode cut(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode middleHead = slow.next;
            slow.next = null;
            return middleHead;
        }

        private ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummy = new ListNode();
            ListNode head = dummy;
            while (head1 != null && head2 != null) {
                if (head1.val >= head2.val) {
                    head.next = head2;
                    head2 = head2.next;
                } else {
                    head.next = head1;
                    head1 = head1.next;
                }
                head = head.next;
            }
            head.next = head1 != null ? head1 : head2;
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P148SortList().new Solution();
        
    } 
}