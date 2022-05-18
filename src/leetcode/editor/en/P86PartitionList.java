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
            ListNode h1 = new ListNode(), p1 = h1;
            ListNode h2 = new ListNode(), p2 = h2;

            while (head != null) {
                ListNode curr = head;
                head = head.next;

                if (curr.val < x) {
                    p1.next = curr;
                    p1 = curr;
                } else {
                    p2.next = curr;
                    p2 = curr;
                }
            }

            p2.next = null;
            p1.next = h2.next;
            return h1.next;
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