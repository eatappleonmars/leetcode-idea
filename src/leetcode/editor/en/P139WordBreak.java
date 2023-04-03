//Given a string s and a dictionary of strings wordDict, return true if s can 
//be segmented into a space-separated sequence of one or more dictionary words. 
//
// Note that the same word in the dictionary may be reused multiple times in 
//the segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
// 
//
// Example 2: 
//
// 
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple 
//pen apple".
//Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
//
// Related Topics Array Hash Table String Dynamic Programming Trie Memoization ?
//? 13705 👎 579


package leetcode.editor.en;

// 2023-04-03 10:23:06

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P139WordBreak {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            // substringResult[i]: result of substring s[i:end)
            boolean substringResult[] = new boolean[s.length() + 1];
            substringResult[s.length()] = true; // for empty substring
            Set<String> wordDictSet = new HashSet<>(wordDict);
            for (int i = s.length() - 1; i >= 0 ; i--) {
                substringResult[i] = wordBreak(i, s, wordDictSet, substringResult);
            }
            return substringResult[0];
        }

        // Check substring s[i:len) and return the result
        private boolean wordBreak(final int beginIndex, String s, Set<String> wordDictSet, boolean[] substringResult) {
            int i = beginIndex;
            StringBuilder sb = new StringBuilder();
            while (i < s.length()) {
                sb.append(s.charAt(i));
                String startingSubstring = sb.toString();
                // Unsolved sub problem s[beginIndex : i], check dictionary
                // Solved sub problem s[i+1 : end), check substring result
                if (wordDictSet.contains(startingSubstring) && substringResult[i+1]) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P139WordBreak().new Solution();
        
    } 
}