//You are given an array of non-overlapping intervals intervals where intervals[
//i] = [starti, endi] represent the start and the end of the iᵗʰ interval and 
//intervals is sorted in ascending order by starti. You are also given an interval 
//newInterval = [start, end] that represents the start and end of another interval. 
//
// Insert newInterval into intervals such that intervals is still sorted in 
//ascending order by starti and intervals still does not have any overlapping 
//intervals (merge overlapping intervals if necessary). 
//
// Return intervals after the insertion. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
// 
//
// 
// Constraints: 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁵ 
// intervals is sorted by starti in ascending order. 
// newInterval.length == 2 
// 0 <= start <= end <= 10⁵ 
// 
//
// Related Topics Array 👍 8618 👎 616


package leetcode.editor.en;

// 2023-07-16 10:52:20

public class P57InsertInterval {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            return sol1WithLinearSearch(intervals, newInterval);
        }

        private int[][] sol1WithLinearSearch(int[][] intervals, int[] newInterval) {
            int len = intervals.length;;
            int[][] tempRes = new int[len + 1][];

            int i = 0; // index for intervals
            int count = 0; // index for tempRes

            int t0 = newInterval[0];
            int t1 = newInterval[1];
            // 1st section: no overlap
            while (i < len && intervals[i][1] < t0) {
                tempRes[count] = intervals[i];
                i++;
                count++;
            }
            // 2nd section: overlap
            tempRes[count] = newInterval;
            count++;
            while (i < len && intervals[i][0] <= t1) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            // 3rd section: no overlap
            while (i < len) {
                tempRes[count] = intervals[i];
                i++;
                count++;
            }
            // Finalize result
            int[][] res = new int[count][];
            for (int j = 0; j < count; j++) {
                res[j] = tempRes[j];
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P57InsertInterval().new Solution();
        
    } 
}