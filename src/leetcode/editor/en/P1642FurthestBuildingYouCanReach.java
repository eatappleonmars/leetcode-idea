//You are given an integer array heights representing the heights of buildings, 
//some bricks, and some ladders. 
//
// You start your journey from building 0 and move to the next building by 
//possibly using bricks or ladders. 
//
// While moving from building i to building i+1 (0-indexed), 
//
// 
// If the current building's height is greater than or equal to the next 
//building's height, you do not need a ladder or bricks. 
// If the current building's height is less than the next building's height, 
//you can either use one ladder or (h[i+1] - h[i]) bricks. 
// 
//
// Return the furthest building index (0-indexed) you can reach if you use the 
//given ladders and bricks optimally. 
//
// 
// Example 1: 
//
// 
//Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
//Output: 4
//Explanation: Starting at building 0, you can follow these steps:
//- Go to building 1 without using ladders nor bricks since 4 >= 2.
//- Go to building 2 using 5 bricks. You must use either bricks or ladders 
//because 2 < 7.
//- Go to building 3 without using ladders nor bricks since 7 >= 6.
//- Go to building 4 using your only ladder. You must use either bricks or 
//ladders because 6 < 9.
//It is impossible to go beyond building 4 because you do not have any more 
//bricks or ladders.
// 
//
// Example 2: 
//
// 
//Input: heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
//Output: 7
// 
//
// Example 3: 
//
// 
//Input: heights = [14,3,19,3], bricks = 17, ladders = 0
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= heights.length <= 10⁵ 
// 1 <= heights[i] <= 10⁶ 
// 0 <= bricks <= 10⁹ 
// 0 <= ladders <= heights.length 
// 
// Related Topics Array Greedy Heap (Priority Queue) 👍 1711 👎 49


package leetcode.editor.en;

// 2022-05-24 15:43:24

import java.util.PriorityQueue;
import java.util.Queue;

public class P1642FurthestBuildingYouCanReach {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {

            Queue<Integer> minDhQueue = new PriorityQueue<>();

            for (int s = 0; s < heights.length - 1; s++) {

                int dh = heights[s+1] - heights[s];

                if (dh <= 0) {
                    continue;
                }

                if (bricks < dh && ladders == 0) {
                    return s;
                }

                minDhQueue.offer(dh);
                if (minDhQueue.size() > ladders) {
                    // In this problem, we don't care where to use ladders. We only need to use ladders
                    // on max dh so far, and use bricks on other dh
                    ladders = 0;
                    bricks -= minDhQueue.poll();
                }
            }
            return heights.length - 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1642FurthestBuildingYouCanReach().new Solution();
        
    } 
}