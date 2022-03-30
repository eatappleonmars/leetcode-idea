//You are given an array of strings equations that represent relationships 
//between variables where each string equations[i] is of length 4 and takes one of two 
//different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (
//not necessarily different) that represent one-letter variable names. 
//
// Return true if it is possible to assign integers to variable names so as to 
//satisfy all the given equations, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: equations = ["a==b","b!=a"]
//Output: false
//Explanation: If we assign say, a = 1 and b = 1, then the first equation is 
//satisfied, but not the second.
//There is no way to assign the variables to satisfy both equations.
// 
//
// Example 2: 
//
// 
//Input: equations = ["b==a","a==b"]
//Output: true
//Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
// 
//
// 
// Constraints: 
//
// 
// 1 <= equations.length <= 500 
// equations[i].length == 4 
// equations[i][0] is a lowercase letter. 
// equations[i][1] is either '=' or '!'. 
// equations[i][2] is '='. 
// equations[i][3] is a lowercase letter. 
// 
// Related Topics Array String Union Find Graph 👍 1452 👎 16


package leetcode.editor.en;

// 2022-03-29 17:18:06

import java.util.Arrays;

public class P990SatisfiabilityOfEqualityEquations {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean equationsPossible(String[] equations) {

            int[] parents = new int[26];
            for (int i = 0; i < 26; i++) {
                parents[i] = i;
            }
            // Process equality
            for (String equation : equations) {
                if (equation.charAt(1) == '!') {
                    continue;
                }
                int xRoot = findRoot(parents, equation.charAt(0) - 'a');
                int yRoot = findRoot(parents, equation.charAt(3) - 'a');

                parents[yRoot] = xRoot;
            }

            for (String equation : equations) {
                if (equation.charAt(1) == '=') {
                    continue;
                }

                int xRoot = findRoot(parents, equation.charAt(0) - 'a');
                int yRoot = findRoot(parents, equation.charAt(3) - 'a');

                if (xRoot == yRoot) {
                    return false;
                }
            }

            return true;
        }

        private int findRoot(int[] parents, int index) {
            while (parents[index] != index) {
                index = parents[index];
            }
            return index;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P990SatisfiabilityOfEqualityEquations().new Solution();
        
    } 
}