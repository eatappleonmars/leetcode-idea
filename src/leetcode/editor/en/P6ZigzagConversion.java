//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
//of rows like this: (you may want to display this pattern in a fixed font for 
//better legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a 
//number of rows: 
//
// 
//string convert(string s, int numRows);
// 
//
// 
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// Example 3: 
//
// 
//Input: s = "A", numRows = 1
//Output: "A"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of English letters (lower-case and upper-case), ',' and '.'. 
// 1 <= numRows <= 1000 
// 
//
// Related Topics String 👍 6350 👎 12603


package leetcode.editor.en;

// 2023-07-05 09:23:44

public class P6ZigzagConversion {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            int i = 0;
            char[] array = new char[s.length()];

            // Example:
            // 0   8     16
            // 1 7 9  15 17
            // 2 6 10 14 18
            // 3 5 11 13 19 21
            // 4   12    20

            // Each row has 2 fixed steps.
            // 1st: 8, 0
            // 2nd: 6, 2
            // 3rd: 4, 4
            // 5th: 2, 6
            // 6th: 0, 8
            int step1 = 2 * numRows - 2;
            int step2 = 0;

            for (int row = 0; row < numRows; row++) {
                // Iterate over the row and pick the characters
                int index = row;
                while (index < s.length()) {
                    if (step1 > 0 && index < s.length()) {
                        array[i] = s.charAt(index);
                        index += step1;
                        i++;
                    }
                    if (step2 > 0 && index < s.length()) {
                        array[i] = s.charAt(index);
                        index += step2;
                        i++;
                    }
                }
                step1 -= 2;
                step2 += 2;
            }
            return new String(array);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P6ZigzagConversion().new Solution();
        
    } 
}