//In an alien language, surprisingly, they also use English lowercase letters, 
//but possibly in a different order. The order of the alphabet is some permutation 
//of lowercase letters. 
//
// Given a sequence of words written in the alien language, and the order of 
//the alphabet, return true if and only if the given words are sorted 
//lexicographically in this alien language. 
//
// 
// Example 1: 
//
// 
//Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//Output: true
//Explanation: As 'h' comes before 'l' in this language, then the sequence is 
//sorted.
// 
//
// Example 2: 
//
// 
//Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//Output: false
//Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1]
//, hence the sequence is unsorted.
// 
//
// Example 3: 
//
// 
//Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//Output: false
//Explanation: The first three characters "app" match, and the second string is 
//shorter (in size.) According to lexicographical rules "apple" > "app", because 
//'l' > '∅', where '∅' is defined as the blank character which is less than any 
//other character (More info).
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 20 
// order.length == 26 
// All characters in words[i] and order are English lowercase letters. 
// 
// Related Topics Array Hash Table String 👍 2317 👎 829


package leetcode.editor.en;

// 2021-11-15 17:18:53

public class P953VerifyingAnAlienDictionary {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            final int[] orderMap = getOrderMap(order);
            for (int i = 0; i < words.length - 1; i++) {
                if (!sorted(words[i], words[i + 1], orderMap)) {
                    return false;
                }
            }
            return true;
        }

        private int[] getOrderMap(final String order) {
            final int[] orderMap = new int[26];
            for (int i = 0; i < order.length(); i++) {
                final char c = order.charAt(i);
                orderMap[c - 'a'] = i;
            }
            return orderMap;
        }

        private boolean sorted(final String w1, final String w2, final int[] orderMap) {

            final int len = Math.min(w1.length(), w2.length());
            for (int i = 0; i < len; i++) {
                final char c1 = w1.charAt(i);
                final char c2 = w2.charAt(i);
                if (c1 != c2) {
                    return orderMap[c1 - 'a'] < orderMap[c2 - 'a'];
                }
            }
            return w1.length() <= w2.length();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P953VerifyingAnAlienDictionary().new Solution();

        final String[] words1 = new String[]{"a"};
        final String order1 = "abc";

        final String[] words2 = new String[]{"hello","leetcode"};
        final String order2 = "hlabcdefgijkmnopqrstuvwxyz";

        final String[] words3 = new String[]{"word","world","row"};
        final String order3 = "worldabcefghijkmnpqstuvxyz";

        final String[] words4 = new String[]{"apple","app"};
        final String order4 = "abcdefghijklmnopqrstuvwxyz";

        final String[] words5 = new String[]{"hello","hello"};
        final String order5 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(sol.isAlienSorted(words1, order1)); // true
        System.out.println(sol.isAlienSorted(words2, order2)); // true
        System.out.println(sol.isAlienSorted(words3, order3)); // true
        System.out.println(sol.isAlienSorted(words4, order4)); // true
        System.out.println(sol.isAlienSorted(words5, order5)); // true
    } 
}