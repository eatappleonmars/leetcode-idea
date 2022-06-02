//You are given an array of words where each word consists of lowercase English 
//letters. 
//
// wordA is a predecessorCheck of wordB if and only if we can insert exactly one 
//letter anywhere in wordA without changing the order of the other characters to make 
//it equal to wordB. 
//
// 
// For example, "abc" is a predecessorCheck of "abac", while "cba" is not a 
//predecessorCheck of "bcad". 
// 
//
// A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, 
//where word1 is a predecessorCheck of word2, word2 is a predecessorCheck of word3, and so 
//on. A single word is trivially a word chain with k == 1. 
//
// Return the length of the longest possible word chain with words chosen from 
//the given list of words. 
//
// 
// Example 1: 
//
// 
//Input: words = ["a","b","ba","bca","bda","bdca"]
//Output: 4
//Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
// 
//
// Example 2: 
//
// 
//Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
//Output: 5
//Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", 
//"pcxbc", "pcxbcf"].
// 
//
// Example 3: 
//
// 
//Input: words = ["abcd","dbqca"]
//Output: 1
//Explanation: The trivial word chain ["abcd"] is one of the longest word 
//chains.
//["abcd","dbqca"] is not a valid word chain because the ordering of the 
//letters is changed.
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 16 
// words[i] only consists of lowercase English letters. 
// 
// Related Topics Array Hash Table Two Pointers String Dynamic Programming 👍 27
//58 👎 133


package leetcode.editor.en;

// 2021-12-01 09:20:19

import java.util.Arrays;
import java.util.Comparator;

public class P1048LongestStringChain {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestStrChain(String[] words) {

            int result = 0;
            int[] dp = new int[words.length];

            int currLen = 0;
            int currLenBeginIndex = 0;

            Arrays.sort(words, Comparator.comparingInt(String::length)); // sort based on string length

            for (int j = 0; j < words.length; j++) {
                String s2 = words[j];
                int s2Len = s2.length();

                if (s2Len != currLen) {
                    currLen = s2Len;
                    currLenBeginIndex = j;
                }

                for (int i = currLenBeginIndex - 1; i >= 0; i--) {
                    String s1 = words[i];
                    int s1Len = s1.length();

                    if (s1Len + 1 < s2Len) {
                        break;
                    }

                    if (predecessorCheck(s1, s2)) {
                        dp[j] = Math.max(dp[j], dp[i] + 1);
                        result = Math.max(result, dp[j]);
                    }
                }
            }
            return result + 1;
        }

        // s1 is the shorter string that has length L
        // s2 is the longer string that has length L + 1
        private boolean predecessorCheck(String s1, String s2) {
            int tolerance = 1;
            for (int i = 0, j = 0; i < s1.length(); i++, j++) {
                if (s2.charAt(j) != s1.charAt(i)) {
                    if (tolerance == 0) {
                        return false;
                    }
                    tolerance--;
                    i--;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1048LongestStringChain().new Solution();
        
    } 
}