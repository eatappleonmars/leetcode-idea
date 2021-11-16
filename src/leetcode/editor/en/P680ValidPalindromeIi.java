//Given a string s, return true if the s can be palindrome after deleting at 
//most one character from it. 
//
// 
// Example 1: 
//
// 
//Input: s = "aba"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "abca"
//Output: true
//Explanation: You could delete the character 'c'.
// 
//
// Example 3: 
//
// 
//Input: s = "abc"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of lowercase English letters. 
// 
// Related Topics Two Pointers String Greedy 👍 3502 👎 215


package leetcode.editor.en;

// 2021-11-15 21:00:56

public class P680ValidPalindromeIi {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean validPalindrome(String s) {
            return valid(s.toCharArray(), 0, s.length() - 1, 0);
        }

        private boolean valid(char[] chars, int lt, int rt, int attempt) {
            if (attempt > 1) {
                return false;
            }
            while (lt < rt) {
                if (chars[lt] != chars[rt]) {
                    attempt++;
                    return valid(chars, lt + 1, rt, attempt) || valid(chars, lt, rt - 1, attempt);
                }
                lt++;
                rt--;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P680ValidPalindromeIi().new Solution();

        final String s1 = "a";
        System.out.println(sol.validPalindrome(s1)); // true

        final String s2 = "aba";
        System.out.println(sol.validPalindrome(s2)); // true

        final String s3 = "abca";
        System.out.println(sol.validPalindrome(s3)); // true

        final String s4 = "abc";
        System.out.println(sol.validPalindrome(s4)); // false

    } 
}