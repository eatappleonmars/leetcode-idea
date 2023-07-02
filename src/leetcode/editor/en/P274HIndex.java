//Given an array of integers citations where citations[i] is the number of 
//citations a researcher received for their iᵗʰ paper, return the researcher's h-index.
// 
//
// According to the definition of h-index on Wikipedia: The h-index is defined 
//as the maximum value of h such that the given researcher has published at least 
//h papers that have each been cited at least h times. 
//
// 
// Example 1: 
//
// 
//Input: citations = [3,0,6,1,5]
//Output: 3
//Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each 
//of them had received 3, 0, 6, 1, 5 citations respectively.
//Since the researcher has 3 papers with at least 3 citations each and the 
//remaining two with no more than 3 citations each, their h-index is 3.
// 
//
// Example 2: 
//
// 
//Input: citations = [1,3,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == citations.length 
// 1 <= n <= 5000 
// 0 <= citations[i] <= 1000 
// 
//
// Related Topics Array Sorting Counting Sort 👍 305 👎 82


package leetcode.editor.en;

// 2023-07-01 17:00:10

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P274HIndex {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hIndex(int[] citations) {
            int[] sortedCitations = Arrays.stream(citations)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
//            return sol1(sortedCitations);
            return sol2(sortedCitations);
        }

        // Sort >> linear search
        private int sol1(int[] sortedCitations) {
            int hIndex = 0;
            for (int i = 1; i <= sortedCitations.length; i++) {
                int h = Math.min(i, sortedCitations[i-1]);
                if (hIndex >= h) {
                    break;
                }
                hIndex = h;
            }
            return hIndex;
        }

        // Sort >> binary search
        private int sol2(int[] sortedCitations) {
            int lt = 0;
            int rt = sortedCitations.length - 1;
            while (lt + 1 < rt) {
                int mid = lt + (rt - lt) / 2;
                int p = mid + 1; // paper count (1-based)
                int c = sortedCitations[mid]; // citation of paper
                if (p == c) {
                    return c;
                }
                if (p < c) {
                    lt = mid;
                } else {
                    rt = mid;
                }
            }

            int h1 = Math.min(1 + lt, sortedCitations[lt]);
            int h2 = Math.min(1 + rt, sortedCitations[rt]);
            return Math.max(h1, h2);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P274HIndex().new Solution();
        
    } 
}