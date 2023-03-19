//You are given a string s and an integer k, a k duplicate removal consists of 
//choosing k adjacent and equal letters from s and removing them, causing the left 
//and the right side of the deleted substring to concatenate together. 
//
// We repeatedly make k duplicate removals on s until we no longer can. 
//
// Return the final string after all such duplicate removals have been made. It 
//is guaranteed that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcd", k = 2
//Output: "abcd"
//Explanation: There's nothing to delete. 
//
// Example 2: 
//
// 
//Input: s = "deeedbbcccbdaa", k = 3
//Output: "aa"
//Explanation: 
//First delete "eee" and "ccc", get "ddbbbdaa"
//Then delete "bbb", get "dddaa"
//Finally delete "ddd", get "aa" 
//
// Example 3: 
//
// 
//Input: s = "pbbcggttciiippooaais", k = 2
//Output: "ps"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// 2 <= k <= 10⁴ 
// s only contains lowercase English letters. 
// 
//
// Related Topics String Stack 👍 5021 👎 94


package leetcode.editor.en;

// 2023-03-18 15:44:44

import java.util.ArrayDeque;
import java.util.Deque;

public class P1209RemoveAllAdjacentDuplicatesInStringIi {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class MyChar {
            char c;
            int count;

            MyChar(char c) {
                this.c = c;
                this.count = 1;
            }
        }

        public String removeDuplicates(String s, int k) {
            // Double-sided queue
            // - Append chars to the tail
            // - Read from head when converting to string
            Deque<MyChar> dQueue = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                appendChar(c, dQueue, k);
            }
            return convertToString(dQueue);
        }

        private void appendChar(char c, Deque<MyChar> dQueue, int k) {
            if (dQueue.isEmpty() || c != dQueue.peekLast().c) {
                dQueue.offerLast(new MyChar(c));
                return;
            }
            MyChar last = dQueue.peekLast();
            if (last.count + 1 == k) {
                dQueue.pollLast();
            } else {
                last.count++;
            }
        }

        private String convertToString(Deque<MyChar> dQueue) {
            StringBuilder sb = new StringBuilder();
            while (!dQueue.isEmpty()) {
                MyChar first = dQueue.pollFirst();
                int count = first.count;
                while (count > 0) {
                    count--;
                    sb.append(first.c);
                }
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1209RemoveAllAdjacentDuplicatesInStringIi().new Solution();
        
    } 
}