//You are given a string s, a split is called good if you can split s into 2 
//non-empty strings p and q where its concatenation is equal to s and the number of 
//distinct letters in p and q are the same. 
//
// Return the number of good splits you can make in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "aacaba"
//Output: 2
//Explanation: There are 5 ways to split "aacaba" and 2 of them are good. 
//("a", "acaba") Left string and right string contains 1 and 3 different 
//letters respectively.
//("aa", "caba") Left string and right string contains 1 and 3 different 
//letters respectively.
//("aac", "aba") Left string and right string contains 2 and 2 different 
//letters respectively (good split).
//("aaca", "ba") Left string and right string contains 2 and 2 different 
//letters respectively (good split).
//("aacab", "a") Left string and right string contains 3 and 1 different 
//letters respectively.
// 
//
// Example 2: 
//
// 
//Input: s = "abcd"
//Output: 1
//Explanation: Split the string as follows ("ab", "cd").
// 
//
// Example 3: 
//
// 
//Input: s = "aaaaa"
//Output: 4
//Explanation: All possible splits are good. 
//
// Example 4: 
//
// 
//Input: s = "acbadbaada"
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// s contains only lowercase English letters. 
// 1 <= s.length <= 10^5 
// Related Topics String Dynamic Programming Bit Manipulation 👍 1029 👎 25


package leetcode.editor.en;

// 2021-11-30 09:48:09

import java.util.function.Function;

public class P1525NumberOfGoodWaysToSplitAString {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSplits(String s) {

            Function<Character, Integer> charIndex  = c -> c - 'a';

            int[] lt = new int[26];
            int[] rt = new int[26];

            int ltDistinctiveCount = 0;
            int rtDistinctiveCount = 0;

            char[] chars = s.toCharArray();

            // Initialize
            for (int i = 0; i < chars.length; i++) {
                int cIndex = charIndex.apply(chars[i]);
                rt[cIndex]++;
                if (rt[cIndex] == 1) {
                    rtDistinctiveCount++;
                }
            }

            // move each char from rt to lt
            int result = 0;
            for (int i = 0; i < chars.length; i++) {
                int cIndex = charIndex.apply(chars[i]);
                lt[cIndex]++;
                rt[cIndex]--;
                if (lt[cIndex] == 1) {
                    ltDistinctiveCount++;
                }
                if (rt[cIndex] == 0) {
                    rtDistinctiveCount--;
                }
                if (ltDistinctiveCount == rtDistinctiveCount) {
                    result++;
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1525NumberOfGoodWaysToSplitAString().new Solution();
        
    } 
}