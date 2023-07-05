//Given an input string s, reverse the order of the words. 
//
// A word is defined as a sequence of non-space characters. The words in s will 
//be separated by at least one space. 
//
// Return a string of the words in reverse order concatenated by a single space.
// 
//
// Note that s may contain leading or trailing spaces or multiple spaces 
//between two words. The returned string should only have a single space separating the 
//words. Do not include any extra spaces. 
//
// 
// Example 1: 
//
// 
//Input: s = "the sky is blue"
//Output: "blue is sky the"
// 
//
// Example 2: 
//
// 
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing 
//spaces.
// 
//
// Example 3: 
//
// 
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single 
//space in the reversed string.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s contains English letters (upper-case and lower-case), digits, and spaces ' 
//'. 
// There is at least one word in s. 
// 
//
// 
// Follow-up: If the string data type is mutable in your language, can you 
//solve it in-place with O(1) extra space? 
//
// Related Topics Two Pointers String 👍 6413 👎 4693


package leetcode.editor.en;

// 2023-07-04 22:40:36

public class P151ReverseWordsInAString {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            return sol1WithCustomUtils(s);
        }

        private String sol1WithCustomUtils(String s) {
            // Remove leading and trailing whitespace and whitespace between words
            char[] array = s.toCharArray();
            int len = clean(array);

            // Reverse entire string
            reverse(array, 0, len-1);

            // Reverse each word in the string
            int prevWhiteSpaceIndex = -1;
            for (int i = 0; i <= len; i++) {
                if (i == len || array[i] == ' ') {
                    reverse(array, prevWhiteSpaceIndex+1, i-1);
                    prevWhiteSpaceIndex = i;
                }
            }
            return new String(array, 0, len);
        }

        private int clean(char[] array) {
            int r = 0;
            int w = 0;
            // Remove leading string by locating the first non-whitespace character
            while (r < array.length) {
                if (array[r] != ' ') {
                    break;
                }
                r++;
            }
            // Remove whitespace between words
            int wsCounter = 0;
            while (r < array.length) {
                char c = array[r];
                if (c == ' ') {
                    wsCounter++;
                    if (wsCounter == 1) {
                        array[w] = array[r];
                        w++;
                    }
                } else {
                    wsCounter = 0;
                    array[w] = array[r];
                    w++;
                }
                r++;
            }
            // Remove trailing single white space
            if (w >= 1 && array[w-1] == ' ') {
                w--;
            }
            return w;
        }

        private void reverse(char[] array, int i, int j) {
            while (i < j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        private void swap(char[] array, int i, int j) {
            char c = array[i];
            array[i] = array[j];
            array[j] = c;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P151ReverseWordsInAString().new Solution();
        
    } 
}