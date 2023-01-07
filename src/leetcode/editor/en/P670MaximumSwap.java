//You are given an integer num. You can swap two digits at most once to get the 
//maximum valued number. 
//
// Return the maximum valued number you can get. 
//
// 
// Example 1: 
//
// 
//Input: num = 2736
//Output: 7236
//Explanation: Swap the number 2 and the number 7.
// 
//
// Example 2: 
//
// 
//Input: num = 9973
//Output: 9973
//Explanation: No swap.
// 
//
// 
// Constraints: 
//
// 
// 0 <= num <= 10⁸ 
// 
//
// Related Topics Math Greedy 👍 2869 👎 164


package leetcode.editor.en;

// 2023-01-07 10:44:13

public class P670MaximumSwap {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // Given a random digit = num[i]:
        // - Assume there is a bigger digit on its right, then we obtain a bigger value after swapping these two digits.
        // - Assume there is a single max digit on its right, then we obtain the max value with the swap.
        // - Assume there are multiple max digits on its right, then we obtain the max value if swapping with the rightmost max digit.
        //   Example, 1323, i = 0 -> [3]32[1]
        //
        // If we can find the first digit = num[i] and swap with rightmost max digit on its right, we obtain global max result.

        public int maximumSwap(int num) {
            if (num < 10) {
                return num;
            }

            char[] digits = String.valueOf(num).toCharArray();

            int swapFromIndex = -1;
            int swapToIndex = -1;

            int i = digits.length - 1;
            // rMaxDigit = rightmostMax(digits[rMaxIndex : end]), rightmost is important
            int rMaxIndex = i;
            int rMaxDigit = digits[rMaxIndex];

            while (i >= 0) {
                if (digits[i] > rMaxDigit) { // Find a new rMax
                    rMaxDigit = digits[i];
                    rMaxIndex = i;
                } else if (digits[i] < rMaxDigit) { // Find a candidate
                    swapFromIndex = i;
                    swapToIndex = rMaxIndex;
                } // skip equal
                i--;
            }

            if (swapFromIndex != -1) {
                char c = digits[swapFromIndex];
                digits[swapFromIndex] = digits[swapToIndex];
                digits[swapToIndex] = c;
            }

            return Integer.parseInt(new String(digits));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P670MaximumSwap().new Solution();
        
    } 
}