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
            // { mask : first index }
            Map<Integer, Integer> seenMasksMap = new HashMap<>();
            seenMasksMap.put(0, -1);

            int maxLen = 1;

            // Mask represents distribution of odd/even numbers. 0 if even and 1 if odd.
            // Example: mask = 1 1 0 means:
            // - number 2 is odd
            // - number 1 is odd
            // - number 0 is even
            // If same mask is seen before, then all odd counts can be cancelled out.
            int mask = 0;

            for (int i = 0; i < s.length(); i++) {
                mask ^= (1 << (s.charAt(i) - '0'));
                seenMasksMap.putIfAbsent(mask, i);

                maxLen = Math.max(maxLen, i - seenMasksMap.get(mask));

                for (int j = 0; j <= 9; j++) {
                    int candidate = mask ^ (1 << j);
                    if (candidate != mask) {
                        // Bit '1' has been turned into bit '0' at index j, indicating we allow
                        // digit j to remain odd and hence all other odd numbers must be cancelled out (seen)
                        maxLen = Math.max(maxLen, i - seenMasksMap.getOrDefault(candidate, i));
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