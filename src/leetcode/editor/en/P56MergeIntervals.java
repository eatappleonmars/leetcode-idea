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
            List<int[]> mergedIntervals = new ArrayList<>();

            int[] lastMergedInterval = intervals[0];
            mergedIntervals.add(lastMergedInterval);

            for (int i = 1; i < intervals.length; i++) {
                int[] currentInterval = intervals[i];

                if (currentInterval[0] <= lastMergedInterval[1]) { // Overlap
                    lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentInterval[1]); // merge, and canMerge remains to be true (implicit)
                } else { // No overlap
                    mergedIntervals.add(currentInterval);
                    lastMergedInterval = currentInterval;
                }
            }
            return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
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