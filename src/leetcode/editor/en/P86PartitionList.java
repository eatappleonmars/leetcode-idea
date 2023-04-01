//Given the head of a linked list and a value x, partition it such that all 
//nodes less than x come before nodes greater than or equal to x. 
//
// You should preserve the original relative order of the nodes in each of the 
//two partitions. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,4,3,2,5,2], x = 3
//Output: [1,2,2,4,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [2,1], x = 2
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 200]. 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics Linked List Two Pointers 👍 3448 👎 484


package leetcode.editor.en;

// 2022-05-18 13:38:02

import utils.ListNode;

public class P86PartitionList {
    
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
        public ListNode partition(ListNode head, int x) {
            final ListNode p1Head = new ListNode();
            final ListNode p2Head = new ListNode();
            ListNode p1Tail = p1Head;
            ListNode p2Tail = p2Head;
            while (head != null) {
                if (head.val < x) {
                    p1Tail.next = head;
                    p1Tail = p1Tail.next;
                } else {
                    p2Tail.next = head;
                    p2Tail = p2Tail.next;
                }
                head = head.next;
            }
            p1Tail.next = p2Head.next;
            p2Tail.next = null;
            return p1Head.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P86PartitionList().new Solution();
        
    } 
}