//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics String Dynamic Programming 👍 17592 👎 1045


package leetcode.editor.en;

// 2022-05-17 21:38:15

public class P5LongestPalindromicSubstring {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {

            int[] beginIndex = new int[]{0};
            int[] maxLen = new int[]{1};

            char[] sArray = s.toCharArray();

            for (int i = 1; i < sArray.length; i++) {
                helper(i, i, sArray, beginIndex, maxLen);
                helper(i-1, i, sArray, beginIndex, maxLen);
            }
            return s.substring(beginIndex[0], beginIndex[0] + maxLen[0]);
        }

        private void helper(int i, int j, char[] array, int[] startIndex, int[] maxLen) {
            while (i >= 0 && j < array.length && array[i] == array[j]) {
                i--;
                j++;
            }
            int len = j - i - 1;
            if (len > maxLen[0]) {
                maxLen[0] = len;
                startIndex[0] = i + 1;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P5LongestPalindromicSubstring().new Solution();
        
    } 
}