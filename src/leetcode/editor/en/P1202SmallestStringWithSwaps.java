//You are given a string s, and an array of pairs of indices in the string 
//pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string. 
//
// You can swap the characters at any pair of indices in the given pairs any 
//number of times. 
//
// Return the lexicographically smallest string that s can be changed to after 
//using the swaps. 
//
// 
// Example 1: 
//
// 
//Input: s = "dcab", pairs = [[0,3],[1,2]]
//Output: "bacd"
//Explaination: 
//Swap s[0] and s[3], s = "bcad"
//Swap s[1] and s[2], s = "bacd"
// 
//
// Example 2: 
//
// 
//Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
//Output: "abcd"
//Explaination: 
//Swap s[0] and s[3], s = "bcad"
//Swap s[0] and s[2], s = "acbd"
//Swap s[1] and s[2], s = "abcd" 
//
// Example 3: 
//
// 
//Input: s = "cba", pairs = [[0,1],[1,2]]
//Output: "abc"
//Explaination: 
//Swap s[0] and s[1], s = "bca"
//Swap s[1] and s[2], s = "bac"
//Swap s[0] and s[1], s = "abc"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10^5 
// 0 <= pairs.length <= 10^5 
// 0 <= pairs[i][0], pairs[i][1] < s.length 
// s only contains lower case English letters. 
// 
// Related Topics Hash Table String Depth-First Search Breadth-First Search 
//Union Find 👍 1472 👎 50


package leetcode.editor.en;

// 2022-03-30 20:37:53

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class P1202SmallestStringWithSwaps {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            int[] parents = new int[s.length()];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
            for (List<Integer> pair : pairs) {
                int mRoot = findRoot(parents, pair.get(0));
                int nRoot = findRoot(parents, pair.get(1));
                // Below if-else statement makes a difference by improving performance from TLE to beating 95%
                if (mRoot < nRoot) {
                    parents[nRoot] = mRoot;
                } else {
                    parents[mRoot] = nRoot;
                }
            }
            char[] sArray = s.toCharArray();
            Map<Integer, Queue<Character>> rootCharsMap = new HashMap<>();
            for (int index = 0; index < parents.length; index++) {
                int root = findRoot(parents, index);
                rootCharsMap.computeIfAbsent(root, r -> new PriorityQueue<>()).add(sArray[index]);
            }

            for (int i = 0; i < s.length(); i++) {
                int root = findRoot(parents, i);
                sArray[i] = rootCharsMap.get(root).poll();
            }
            return new String(sArray);
        }

        private int findRoot(int[] parents, int index) {
            while (index != parents[index]) {
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
        Solution sol = new P1202SmallestStringWithSwaps().new Solution();
        
    } 
}