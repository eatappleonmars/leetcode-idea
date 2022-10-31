//Given a Circular Linked List node, which is sorted in non-descending order, 
//write a function to insert a value insertVal into the list such that it remains a 
//sorted circular list. The given node can be a reference to any single node in 
//the list and may not necessarily be the smallest value in the circular list. 
//
// If there are multiple suitable places for insertion, you may choose any 
//place to insert the new value. After the insertion, the circular list should remain 
//sorted. 
//
// If the list is empty (i.e., the given node is null), you should create a new 
//single circular list and return the reference to that single node. Otherwise, 
//you should return the originally given node. 
//
// 
// Example 1: 
//
// 
// 
//Input: head = [3,4,1], insertVal = 2
//Output: [3,4,1,2]
//Explanation: In the figure above, there is a sorted circular list of three 
//elements. You are given a reference to the node with value 3, and we need to 
//insert 2 into the list. The new node should be inserted between node 1 and node 3. 
//After the insertion, the list should look like this, and we should still return 
//node 3.
// 
//
//
//
//
// Example 2: 
//
// 
//Input: head = [], insertVal = 1
//Output: [1]
//Explanation: The list is empty (given head is null). We create a new single 
//circular list and return the reference to that single node.
// 
//
// Example 3: 
//
// 
//Input: head = [1], insertVal = 0
//Output: [1,0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 5 * 10⁴]. 
// -10⁶ <= Node.val, insertVal <= 10⁶ 
// 
//
// Related Topics Linked List 👍 1015 👎 672


package leetcode.editor.en;

// 2022-10-30 17:23:03

import utils.Node;

public class P708InsertIntoASortedCircularLinkedList {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
    */

    class Solution {
        public Node insert(Node head, int insertVal) {
            if (head == null) {
                Node insertNode = new Node(insertVal);
                insertNode.next = insertNode;
                return insertNode;
            }
            Node curr = head;
            Node next = head.next;

            while (next != head) {
                if (curr.val > next.val) { // max-min fault
                    int max = curr.val;
                    int min = next.val;
                    if (insertVal >= max || insertVal < min) {
                        break;
                    }
                } else if (insertVal >= curr.val && insertVal <= curr.next.val) {
                    break;
                }
                curr = next;
                next = next.next;
            }
            Node insertNode = new Node(insertVal);
            insertNode.next = curr.next;
            curr.next = insertNode;
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P708InsertIntoASortedCircularLinkedList().new Solution();
        
    } 
}