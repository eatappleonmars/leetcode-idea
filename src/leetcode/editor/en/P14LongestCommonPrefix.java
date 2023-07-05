//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lowercase English letters. 
// 
//
// Related Topics String Trie 👍 14564 👎 4034


package leetcode.editor.en;

// 2023-07-04 22:27:10

public class P14LongestCommonPrefix {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            // Use the 1st string for later comparisons
            char[] chars = strs[0].toCharArray();
            int commonPrefixLen = chars.length;
            for (int i = 1; i < strs.length; i++) {
                // Fast fail when the longest common prefix is 0
                if (commonPrefixLen == 0) {
                    return "";
                }
                String s = strs[i];
                int j = 0;
                // character-wise comparison
                while (j < Math.min(s.length(), commonPrefixLen)) {
                    if (s.charAt(j) != chars[j]) {
                        break;
                    }
                    j++;
                }
                // update longest common prefix
                commonPrefixLen = j;
            }
            return strs[0].substring(0, commonPrefixLen);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P14LongestCommonPrefix().new Solution();
        
    } 
}