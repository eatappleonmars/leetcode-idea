//You are given a 0-indexed string s that you must perform k replacement 
//operations on. The replacement operations are given as three 0-indexed parallel arrays,
// indices, sources, and targets, all of length k. 
//
// To complete the iᵗʰ replacement operation: 
//
// 
// Check if the substring sources[i] occurs at index indices[i] in the original 
//string s. 
// If it does not occur, do nothing. 
// Otherwise if it does occur, replace that substring with targets[i]. 
// 
//
// For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i]
// = "eee", then the result of this replacement will be "eeecd". 
//
// All replacement operations must occur simultaneously, meaning the 
//replacement operations should not affect the indexing of each other. The testcases will be 
//generated such that the replacements will not overlap. 
//
// 
// For example, a testcase with s = "abc", indices = [0, 1], and sources = [
//"ab","bc"] will not be generated because the "ab" and "bc" replacements overlap. 
// 
//
// Return the resulting string after performing all replacement operations on s.
// 
//
// A substring is a contiguous sequence of characters in a string. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", 
//"ffff"]
//Output: "eeebffff"
//Explanation:
//"a" occurs at index 0 in s, so we replace it with "eee".
//"cd" occurs at index 2 in s, so we replace it with "ffff".
// 
//
// Example 2: 
//
// 
//Input: s = "abcd", indices = [0, 2], sources = ["ab","ec"], targets = ["eee",
//"ffff"]
//Output: "eeecd"
//Explanation:
//"ab" occurs at index 0 in s, so we replace it with "eee".
//"ec" does not occur at index 2 in s, so we do nothing.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// k == indices.length == sources.length == targets.length 
// 1 <= k <= 100 
// 0 <= indexes[i] < s.length 
// 1 <= sources[i].length, targets[i].length <= 50 
// s consists of only lowercase English letters. 
// sources[i] and targets[i] consist of only lowercase English letters. 
// 
// Related Topics Array String Sorting 👍 623 👎 663


package leetcode.editor.en;

// 2021-11-28 21:21:59

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class P833FindAndReplaceInString {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

            List<int[]> sortedIndices = new ArrayList<>();
            int k = indices.length;

            for (int i = 0; i < k; i++) {
                sortedIndices.add(new int[]{indices[i], i});
            }
            sortedIndices.sort(Comparator.comparing(element -> element[0]));

            StringBuilder sb = new StringBuilder();

            int beg = 0;
            for (int[] sortedIndex : sortedIndices) {
                int end = sortedIndex[0];
                int i = sortedIndex[1];

                // Add s[beg:end) to StringBuilder
                appendSubstring(sb, s, beg, end);
                beg = end;
                // replace substring if meet criteria
                String source = sources[i];
                if (match(s, end, source)) {
                    sb.append(targets[i]);
                    beg += source.length();
                }
            }
            // Add the rest to StringBuilder
            appendSubstring(sb, s, beg, s.length());

            return sb.toString();
        }

        private void appendSubstring(StringBuilder sb, String s, int beg, int end) {
            while (beg < end) {
                sb.append(s.charAt(beg));
                beg++;
            }
        }

        private boolean match(String s, int beg, String source) {
            int sRemainLen = s.length() - beg;
            if (sRemainLen < source.length()) {
                return false;
            }
            for (int i = beg, j = 0; j < source.length(); i++, j++) {
                if (s.charAt(i) != source.charAt(j)) {
                    return false;
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
        Solution sol = new P833FindAndReplaceInString().new Solution();
        
    } 
}