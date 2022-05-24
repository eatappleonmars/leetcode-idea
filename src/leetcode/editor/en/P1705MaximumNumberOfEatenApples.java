//There is a special kind of apple tree that grows apples every day for n days. 
//On the iᵗʰ day, the tree grows apples[i] apples that will rot after days[i] 
//days, that is on day i + days[i] the apples will be rotten and cannot be eaten. On 
//some days, the apple tree does not grow any apples, which are denoted by apples[
//i] == 0 and days[i] == 0. 
//
// You decided to eat at most one apple a day (to keep the doctors away). Note 
//that you can keep eating after the first n days. 
//
// Given two integer arrays days and apples of length n, return the maximum 
//number of apples you can eat. 
//
// 
// Example 1: 
//
// 
//Input: apples = [1,2,3,5,2], days = [3,2,1,4,2]
//Output: 7
//Explanation: You can eat 7 apples:
//- On the first day, you eat an apple that grew on the first day.
//- On the second day, you eat an apple that grew on the second day.
//- On the third day, you eat an apple that grew on the second day. After this 
//day, the apples that grew on the third day rot.
//- On the fourth to the seventh days, you eat apples that grew on the fourth 
//day.
// 
//
// Example 2: 
//
// 
//Input: apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
//Output: 5
//Explanation: You can eat 5 apples:
//- On the first to the third day you eat apples that grew on the first day.
//- Do nothing on the fouth and fifth days.
//- On the sixth and seventh days you eat apples that grew on the sixth day.
// 
//
// 
// Constraints: 
//
// 
// n == apples.length == days.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= apples[i], days[i] <= 2 * 10⁴ 
// days[i] = 0 if and only if apples[i] = 0. 
// 
// Related Topics Array Greedy Heap (Priority Queue) 👍 502 👎 145


package leetcode.editor.en;

// 2022-05-24 13:38:17

import java.util.Comparator;
import java.util.PriorityQueue;

public class P1705MaximumNumberOfEatenApples {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            PriorityQueue<Integer> rottingAppleQueue = new PriorityQueue<>(Comparator.comparingInt(i -> i + days[i]));

            int eatCount = 0;
            int today = 0;

            // For days when apples are growing
            for (; today < days.length; today++) {
                // Throw away rotten apples
                throwAwayRottenApples(rottingAppleQueue, today, days);
                // Pick apples
                if (apples[today] > 0 && days[today] > 0) {
                    rottingAppleQueue.offer(today);
                }
                // Eat an apple if any
                if (!rottingAppleQueue.isEmpty()) {
                    int pickDay = rottingAppleQueue.peek();
                    apples[pickDay]--;
                    eatCount++;
                    if (apples[pickDay] == 0) {
                        rottingAppleQueue.poll();
                    }
                }
            }

            // keep eating until no more apples
            while (true) {
                throwAwayRottenApples(rottingAppleQueue, today, days);

                if (rottingAppleQueue.isEmpty()) {
                    break;
                }

                int pickDay = rottingAppleQueue.poll();
                int rottenDay = pickDay + days[pickDay];
                int remainingFreshDays = rottenDay - today;

                int totalCount = apples[pickDay];
                int canEatCount = Math.min(totalCount, remainingFreshDays);

                eatCount += canEatCount;
                today += canEatCount; // fast-forward on time
            }

            return eatCount;
        }

        private void throwAwayRottenApples(PriorityQueue<Integer> rottingAppleQueue, int today, int[] days) {
            while (!rottingAppleQueue.isEmpty()) {
                int pickDay = rottingAppleQueue.peek();
                if (pickDay + days[pickDay] > today) {
                    break;
                }
                rottingAppleQueue.poll();
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1705MaximumNumberOfEatenApples().new Solution();
        
    } 
}