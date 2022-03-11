//A wonderful string is a string where at most one letter appears an odd number 
//of times. 
//
// 
// For example, "ccjjc" and "abab" are wonderful, but "ab" is not. 
// 
//
// Given a string word that consists of the first ten lowercase English letters 
//('a' through 'j'), return the number of wonderful non-empty substrings in word. 
//If the same substring appears multiple times in word, then count each 
//occurrence separately. 
//
// A substring is a contiguous sequence of characters in a string. 
//
// 
// Example 1: 
//
// 
//Input: word = "aba"
//Output: 4
//Explanation: The four wonderful substrings are underlined below:
//- "aba" -> "a"
//- "aba" -> "b"
//- "aba" -> "a"
//- "aba" -> "aba"
// 
//
// Example 2: 
//
// 
//Input: word = "aabb"
//Output: 9
//Explanation: The nine wonderful substrings are underlined below:
//- "aabb" -> "a"
//- "aabb" -> "aa"
//- "aabb" -> "aab"
//- "aabb" -> "aabb"
//- "aabb" -> "a"
//- "aabb" -> "abb"
//- "aabb" -> "b"
//- "aabb" -> "bb"
//- "aabb" -> "b"
// 
//
// Example 3: 
//
// 
//Input: word = "he"
//Output: 2
//Explanation: The two wonderful substrings are underlined below:
//- "he" -> "h"
//- "he" -> "e"
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length <= 10⁵ 
// word consists of lowercase English letters from 'a' to 'j'. 
// Related Topics Hash Table String Bit Manipulation Prefix Sum 👍 580 👎 42


package leetcode.editor.en;

// 2022-03-09 22:26:03

import java.util.HashMap;
import java.util.Map;

public class P1915NumberOfWonderfulSubstrings {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long wonderfulSubstrings(String word) {

            long res = 0;

            long[] seen = new long[1024];
            seen[0] = 1;

            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                int bitIndex =
                mask ^= 1 << (word.charAt(i) - 'a'); // toggle at bit index
                // If current prefix mask and a previously seen prefix mask only differ by at most 1 bit,
                // the subarray is wonderful.
                // Problem statement: mask ^ seen --> at most 1 bit equals 1
                // Solution:
                // (mask ^ mask) ^ seen = seen --> mask ^ (at most 1 bit equals 1)
                res += seen[mask];
                for (int j = 0; j < 10; j++) {
                    res += seen[mask ^ (1 << j)];
                }
                seen[mask]++;
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1915NumberOfWonderfulSubstrings().new Solution();
        
    } 
}