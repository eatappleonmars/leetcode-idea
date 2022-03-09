//You are given a string s. An awesome substring is a non-empty substring of s 
//such that we can make any number of swaps in order to make it a palindrome. 
//
// Return the length of the maximum length awesome substring of s. 
//
// 
// Example 1: 
//
// 
//Input: s = "3242415"
//Output: 5
//Explanation: "24241" is the longest awesome substring, we can form the 
//palindrome "24142" with some swaps.
// 
//
// Example 2: 
//
// 
//Input: s = "12345678"
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: s = "213123"
//Output: 6
//Explanation: "213123" is the longest awesome substring, we can form the 
//palindrome "231132" with some swaps.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists only of digits. 
// 
// Related Topics Hash Table String Bit Manipulation 👍 493 👎 11


package leetcode.editor.en;

// 2022-03-09 09:39:27

import java.util.HashMap;
import java.util.Map;

public class P1542FindLongestAwesomeSubstring {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // Problem statement
        // Find the longest substring such that the count of
        // each contained digit is even, or
        // at most one digit among all is odd
        public int longestAwesome(String s) {

            int maxLen = 1;

            // { seen mask : index }
            Map<Integer, Integer> seen = new HashMap<>();
            seen.put(0, -1);

            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';
                mask ^= (1 << digit); // flip bit in mask to represent even/odd count
                seen.putIfAbsent(mask, i);
                // First candidate
                maxLen = Math.max(maxLen, i - seen.get(mask));
                // Other 10 candidates
                for (int j = 0; j < 10; j++) {
                    // Get candidate by flipping only i-th bit in mask
                    // Example: mask = 7626
                    //        9 8 7 6 5 4 3 2 1 0
                    // mask:  0 0 1 0 0 0 0 1 0 0 (mask: 7626)
                    // flip-2: 0 0 1 0 0 0 0 0 0 0 (mask: 7, seen before)
                    // If "flip-2" exists, it means "2" can be kept odd while
                    // other odd digits such as "7" can be cancelled out

                    int candidate = mask ^ (1 << j);
                    if (seen.containsKey(candidate)) {
                        maxLen = Math.max(maxLen, i - seen.get(candidate));
                    }
                }
            }

            return maxLen;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1542FindLongestAwesomeSubstring().new Solution();
        
    } 
}