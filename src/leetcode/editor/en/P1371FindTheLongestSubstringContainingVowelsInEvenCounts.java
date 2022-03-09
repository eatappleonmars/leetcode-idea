//Given the string s, return the size of the longest substring containing each 
//vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear 
//an even number of times. 
//
// 
// Example 1: 
//
// 
//Input: s = "eleetminicoworoep"
//Output: 13
//Explanation: The longest substring is "leetminicowor" which contains two each 
//of the vowels: e, i and o and zero of the vowels: a and u.
// 
//
// Example 2: 
//
// 
//Input: s = "leetcodeisgreat"
//Output: 5
//Explanation: The longest substring is "leetc" which contains two e's.
// 
//
// Example 3: 
//
// 
//Input: s = "bcbcbc"
//Output: 6
//Explanation: In this case, the given string "bcbcbc" is the longest because 
//all vowels: a, e, i, o and u appear zero times.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 x 10^5 
// s contains only lowercase English letters. 
// 
// Related Topics Hash Table String Bit Manipulation Prefix Sum 👍 1049 👎 40


package leetcode.editor.en;

// 2022-03-08 17:48:42

import java.util.HashMap;
import java.util.Map;

public class P1371FindTheLongestSubstringContainingVowelsInEvenCounts {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTheLongestSubstring(String s) {
            // Use bits to represent the state of vowels as we only care about if vowels have odd(1) or even(0) number
            int vowelsState = 0;
            // We will use XOR to flip the bit later
            Map<Character, Integer> vowelsBitMap = Map.of(
                    'a', 1, // 00001
                    'e', 2, // 00010
                    'i', 4, // 00100
                    'o', 8, // 01000
                    'u', 16 // 10000
            );

            int longest = 0;
            Map<Integer, Integer> seen = new HashMap<>(); // { n : index }
            seen.put(0, -1);

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (vowelsBitMap.containsKey(c)) {
                    vowelsState = vowelsState ^ vowelsBitMap.get(c); // XOR to flip 0 to 1 or vice versa
                }
                seen.putIfAbsent(vowelsState, i);
                longest = Math.max(longest, i - seen.get(vowelsState));
            }

            return longest;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1371FindTheLongestSubstringContainingVowelsInEvenCounts().new Solution();
        
    } 
}