//A string s is called happy if it satisfies the following conditions: 
//
// 
// s only contains the letters 'a', 'b', and 'c'. 
// s does not contain any of "aaa", "bbb", or "ccc" as a substring. 
// s contains at most a occurrences of the letter 'a'. 
// s contains at most b occurrences of the letter 'b'. 
// s contains at most c occurrences of the letter 'c'. 
// 
//
// Given three integers a, b, and c, return the longest possible happy string. 
//If there are multiple longest happy strings, return any of them. If there is no 
//such string, return the empty string "". 
//
// A substring is a contiguous sequence of characters within a string. 
//
// 
// Example 1: 
//
// 
//Input: a = 1, b = 1, c = 7
//Output: "ccaccbcc"
//Explanation: "ccbccacc" would also be a correct answer.
// 
//
// Example 2: 
//
// 
//Input: a = 7, b = 1, c = 0
//Output: "aabaa"
//Explanation: It is the only correct answer in this case.
// 
//
// 
// Constraints: 
//
// 
// 0 <= a, b, c <= 100 
// a + b + c > 0 
// 
// Related Topics String Greedy Heap (Priority Queue) 👍 1023 👎 172


package leetcode.editor.en;

// 2022-03-12 14:19:21

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1405LongestHappyString {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestDiverseString(int a, int b, int c) {
            // [ charInt, count ]
            Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(s -> -s[1]));
            
            if (a > 0) pq.offer(new int[]{0, a});
            if (b > 0) pq.offer(new int[]{1, b});
            if (c > 0) pq.offer(new int[]{2, c});

            StringBuilder sb = new StringBuilder();

            int prev = 0, repeat = 0;

            while (!pq.isEmpty()) {

                int[] candidate = pq.poll();

                if (prev == candidate[0] && repeat == 2) { // reach max repeat count, skip
                    if (pq.isEmpty()) { // no other candidate, terminate
                        break;
                    }
                    int[] skip = candidate;
                    candidate = pq.poll();
                    pq.offer(skip);
                }

                if (prev != candidate[0]) {
                    prev = candidate[0];
                    repeat = 0;
                }
                repeat++;

                candidate[1]--;
                if (candidate[1] > 0) {
                    pq.offer(candidate);
                }

                sb.append((char) (candidate[0] + 'a'));
            }

            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1405LongestHappyString().new Solution();
        
    } 
}