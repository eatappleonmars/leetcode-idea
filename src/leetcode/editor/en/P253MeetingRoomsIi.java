//Given an array of meeting time intervals intervals where intervals[i] = [
//starti, endi], return the minimum number of conference rooms required. 
//
// 
// Example 1: 
// Input: intervals = [[0,30],[5,10],[15,20]]
//Output: 2
// Example 2: 
// Input: intervals = [[7,10],[2,4]]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// 0 <= starti < endi <= 10⁶ 
// 
// Related Topics Array Two Pointers Greedy Sorting Heap (Priority Queue) 👍 544
//7 👎 107


package leetcode.editor.en;

// 2022-05-05 09:13:23

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P253MeetingRoomsIi {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
            Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(interval -> interval[1]));
            pq.offer(intervals[0]);
            int res = 1;
            for (int i = 1; i < intervals.length; i++) {
                int[] interval = intervals[i];
                if (pq.peek()[1] <= interval[0]) { // some meeting has ended
                    pq.poll();
                }
                pq.offer(interval);
                res = Math.max(res, pq.size());
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P253MeetingRoomsIi().new Solution();
        
    } 
}