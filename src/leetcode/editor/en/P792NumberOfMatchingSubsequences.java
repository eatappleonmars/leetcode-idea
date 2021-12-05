//Given a string s and an array of strings words, return the number of words[i] 
//that is a subsequence of s. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters (can be none) deleted without changing the relative order 
//of the remaining characters. 
//
// 
// For example, "ace" is a subsequence of "abcde". 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "abcde", words = ["a","bb","acd","ace"]
//Output: 3
//Explanation: There are three strings in words that are a subsequence of s: 
//"a", "acd", "ace".
// 
//
// Example 2: 
//
// 
//Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 50 
// s and words[i] consist of only lowercase English letters. 
// 
// Related Topics Hash Table String Trie Sorting 👍 2381 👎 129


package leetcode.editor.en;

// 2021-12-05 10:48:04

import java.util.ArrayList;
import java.util.List;

public class P792NumberOfMatchingSubsequences {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            List<List<Integer>> indexMap = getIndexMap(s);

            int count = 0;
            for (String word : words) {
                count += matchingSubsequence(word, indexMap);
            }
            return count;
        }

        private List<List<Integer>> getIndexMap(String s) {
            List<List<Integer>> indexMap = new ArrayList<>(26);
            for (int i = 0; i < 26; i++) {
                indexMap.add(new ArrayList<>());
            }
            for (int i = 0; i < s.length(); i++) {
                int charIndex = s.charAt(i) - 'a';
                indexMap.get(charIndex).add(i);
            }
            return indexMap;
        }

        private int matchingSubsequence(String matchingWord, List<List<Integer>> indexMap) {
            // Latest matched index of char in original word (now represented as indexMap)
            // Need to track it to ensure matching order is preserved
            int matchedIndexInWord = -1;

            // In case of repeated same character access, visitingIndexes[i] is updated for each match attempt
            // such that it provides hint on begin index for next match
            int[] visitingIndexes = new int[26];

            for (char c : matchingWord.toCharArray()) {
                boolean cMatched = false;
                int cIndex = c - 'a';
                int visitingIndex = visitingIndexes[cIndex];
                List<Integer> cIndexes = indexMap.get(cIndex);

                for (int i = visitingIndex; i < cIndexes.size(); i++) {
                    visitingIndexes[cIndex]++;
                    int cIndexInWord = cIndexes.get(i);
                    if (cIndexInWord <= matchedIndexInWord) {
                        continue; // invalid because order needs to be preserved
                    }
                    // Found matching character, update and return
                    matchedIndexInWord = cIndexInWord;
                    cMatched = true;
                    break;
                }

                if (!cMatched) {
                    return 0;
                }
            }
            return 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P792NumberOfMatchingSubsequences().new Solution();
        
    } 
}