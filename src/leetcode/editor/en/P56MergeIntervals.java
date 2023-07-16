//Given an array of intervals where intervals[i] = [starti, endi], merge all 
//overlapping intervals, and return an array of the non-overlapping intervals that 
//cover all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics Array Sorting 👍 17228 👎 611


package leetcode.editor.en;

// 2022-12-05 22:18:58

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P56MergeIntervals {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(array -> array[0]));
            int len = intervals.length;;
            int[][] tempRes = new int[len][];

            tempRes[0] = intervals[0];
            int count = 1;

            for (int i = 1; i < len; i++) {
                int[] currInterval = intervals[i];
                int[] prevInterval = tempRes[count - 1];


                if (currInterval[0] > prevInterval[1]) { // No overlap
                    tempRes[count] = currInterval;
                    count++;
                } else { // No overlap
                    prevInterval[1] = Math.max(prevInterval[1], currInterval[1]); // merge, and canMerge remains to be true (implicit)
                }
            }

            int[][] res = new int[count][];
            for (int i = 0; i < count; i++) {
                res[i] = tempRes[i];
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P56MergeIntervals().new Solution();
        
    } 
}