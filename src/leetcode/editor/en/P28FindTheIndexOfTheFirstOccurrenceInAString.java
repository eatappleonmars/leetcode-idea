//Given two strings needle and haystack, return the index of the first 
//occurrence of needle in haystack, or -1 if needle is not part of haystack. 
//
// 
// Example 1: 
//
// 
//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.
// 
//
// Example 2: 
//
// 
//Input: haystack = "leetcode", needle = "leeto"
//Output: -1
//Explanation: "leeto" did not occur in "leetcode", so we return -1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack and needle consist of only lowercase English characters. 
// 
//
// Related Topics Two Pointers String String Matching 👍 3907 👎 213


package leetcode.editor.en;

// 2023-07-05 21:23:29

public class P28FindTheIndexOfTheFirstOccurrenceInAString {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            for (int i = 0; i < haystack.length(); i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    int index = charWiseComparison(haystack, i, needle, 0);
                    if (index >= 0) {
                        return index;
                    }
                }
            }
            return -1;
        }

        private int charWiseComparison(String haystack, int i, String needle, int j) {
            if (haystack.length() - i < needle.length()) {
                return -1;
            }
            while (i < haystack.length() && j < needle.length()) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    return -1;
                }
                i++;
                j++;
            }
            return i - needle.length();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P28FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        
    } 
}