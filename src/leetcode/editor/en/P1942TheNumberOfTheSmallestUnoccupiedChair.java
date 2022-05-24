//There is a party where n friends numbered from 0 to n - 1 are attending. 
//There is an infinite number of chairs in this party that are numbered from 0 to 
//infinity. When a friend arrives at the party, they sit on the unoccupied chair with 
//the smallest number. 
//
// 
// For example, if chairs 0, 1, and 5 are occupied when a friend comes, they 
//will sit on chair number 2. 
// 
//
// When a friend leaves the party, their chair becomes unoccupied at the moment 
//they leave. If another friend arrives at that same moment, they can sit in that 
//chair. 
//
// You are given a 0-indexed 2D integer array times where times[i] = [arrivali, 
//leavingi], indicating the arrival and leaving times of the iᵗʰ friend 
//respectively, and an integer targetFriend. All arrival times are distinct. 
//
// Return the chair number that the friend numbered targetFriend will sit on. 
//
// 
// Example 1: 
//
// 
//Input: times = [[1,4],[2,3],[4,6]], targetFriend = 1
//Output: 1
//Explanation: 
//- Friend 0 arrives at time 1 and sits on chair 0.
//- Friend 1 arrives at time 2 and sits on chair 1.
//- Friend 1 leaves at time 3 and chair 1 becomes empty.
//- Friend 0 leaves at time 4 and chair 0 becomes empty.
//- Friend 2 arrives at time 4 and sits on chair 0.
//Since friend 1 sat on chair 1, we return 1.
// 
//
// Example 2: 
//
// 
//Input: times = [[3,10],[1,5],[2,6]], targetFriend = 0
//Output: 2
//Explanation: 
//- Friend 1 arrives at time 1 and sits on chair 0.
//- Friend 2 arrives at time 2 and sits on chair 1.
//- Friend 0 arrives at time 3 and sits on chair 2.
//- Friend 1 leaves at time 5 and chair 0 becomes empty.
//- Friend 2 leaves at time 6 and chair 1 becomes empty.
//- Friend 0 leaves at time 10 and chair 2 becomes empty.
//Since friend 0 sat on chair 2, we return 2.
// 
//
// 
// Constraints: 
//
// 
// n == times.length 
// 2 <= n <= 10⁴ 
// times[i].length == 2 
// 1 <= arrivali < leavingi <= 10⁵ 
// 0 <= targetFriend <= n - 1 
// Each arrivali time is distinct. 
// 
// Related Topics Array Heap (Priority Queue) Ordered Set 👍 381 👎 20


package leetcode.editor.en;

// 2022-05-24 09:28:58

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1942TheNumberOfTheSmallestUnoccupiedChair {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestChair(int[][] times, int targetFriend) {

            int newChairId = 0; // smallest new chair id
            Queue<Integer> chairQueue = new PriorityQueue<>(); // used, available chairs
            Queue<int[]> leavingQueue = new PriorityQueue<>(Comparator.comparingInt(time -> time[1]));

            int targetArrivalTime = times[targetFriend][0]; // save the time before info is lost after sorting
            Arrays.sort(times, Comparator.comparingInt(time -> time[0])); // sort by arrival time

            int takenChairId = 0;

            for (int[] time : times) {
                int arrivalTime = time[0];
                // Some people may have left and chairs become available again
                while (!leavingQueue.isEmpty() && leavingQueue.peek()[1] <= arrivalTime) {
                    chairQueue.offer(leavingQueue.poll()[0]);
                }
                // Take a chair
                if (!chairQueue.isEmpty()) {
                    takenChairId = chairQueue.poll();
                } else {
                    takenChairId = newChairId;
                    newChairId++;
                }

                if (arrivalTime == targetArrivalTime) {
                    break;
                } else {
                    // Arrive time is no longer useful. Use the slot to store assigned chair Id
                    time[0] = takenChairId;
                    leavingQueue.offer(time);
                }
            }

            return takenChairId;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1942TheNumberOfTheSmallestUnoccupiedChair().new Solution();
        
    } 
}