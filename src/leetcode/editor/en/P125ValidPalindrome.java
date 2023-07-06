//A phrase is a palindrome if, after converting all uppercase letters into 
//lowercase letters and removing all non-alphanumeric characters, it reads the same 
//forward and backward. Alphanumeric characters include letters and numbers. 
//
// Given a string s, return true if it is a palindrome, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric 
//characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s consists only of printable ASCII characters. 
// 
//
// Related Topics Two Pointers String 👍 7263 👎 7326


package leetcode.editor.en;

// 2023-07-05 21:34:51

public class P125ValidPalindrome {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            char[] array = s.toCharArray();
            int len = removeNonAlphanumericCharacters(array);
            int i = 0, j = len - 1;
            while (i < j) {
                if (array[i] != array[j]) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

        private int removeNonAlphanumericCharacters(char[] array) {
            int w = 0;
            for (char c : array) {
                if (Character.isLetterOrDigit(c)) {
                    array[w] = Character.toLowerCase(c);
                    w++;
                }
            }
            return w;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P125ValidPalindrome().new Solution();
        
    } 
}