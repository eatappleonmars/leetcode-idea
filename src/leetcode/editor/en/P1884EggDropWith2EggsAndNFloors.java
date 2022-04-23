//You are given two identical eggs and you have access to a building with n 
//floors labeled from 1 to n. 
//
// You know that there exists a floor f where 0 <= f <= n such that any egg 
//dropped at a floor higher than f will break, and any egg dropped at or below floor 
//f will not break. 
//
// In each move, you may take an unbroken egg and drop it from any floor x (
//where 1 <= x <= n). If the egg breaks, you can no longer use it. However, if the 
//egg does not break, you may reuse it in future moves. 
//
// Return the minimum number of moves that you need to determine with certainty 
//what the value of f is. 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: We can drop the first egg from floor 1 and the second egg from 
//floor 2.
//If the first egg breaks, we know that f = 0.
//If the second egg breaks but the first egg didn't, we know that f = 1.
//Otherwise, if both eggs survive, we know that f = 2.
// 
//
// Example 2: 
//
// 
//Input: n = 100
//Output: 14
//Explanation: One optimal strategy is:
//- Drop the 1st egg at floor 9. If it breaks, we know f is between 0 and 8. 
//Drop the 2nd egg starting from floor 1 and going up one at a time to find f within 
//8 more drops. Total drops is 1 + 8 = 9.
//- If the 1st egg does not break, drop the 1st egg again at floor 22. If it 
//breaks, we know f is between 9 and 21. Drop the 2nd egg starting from floor 10 and 
//going up one at a time to find f within 12 more drops. Total drops is 2 + 12 = 1
//4.
//- If the 1st egg does not break again, follow a similar process dropping the 1
//st egg from floors 34, 45, 55, 64, 72, 79, 85, 90, 94, 97, 99, and 100.
//Regardless of the outcome, it takes at most 14 drops to determine f.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 1000 
// 
// Related Topics Math Dynamic Programming 👍 698 👎 61


package leetcode.editor.en;

// 2022-04-22 15:56:17

public class P1884EggDropWith2EggsAndNFloors {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int twoEggDrop(int n) {
            // Min number of moves if there are two eggs
            int[] dpTwo = new int[n + 1];
            dpTwo[1] = 1;
            for (int numFloors = 2; numFloors <= n; numFloors++) {
                int minMoves = minMoves(numFloors, dpTwo);
                dpTwo[numFloors] = minMoves;
            }

            return dpTwo[n];
        }

        // Note:
        // With optimal solution, iteration is redundant. But why?
        // Only need to test one case when f == 1
        //
        // Given number of floors to test, return the min number to moves
        private int minMoves(int numFloors, int[] dpTwo) {
            int min = numFloors;
            for (int f = 1; f <= numFloors / 2 + 1; f++) {
                // Case 1: egg breaks at f-th floor, convert to 1-egg problem in remaining floors below f-th floor
                int c1 = f - 1;
                // Case 2: egg survives at f-th floor, convert to 2-egg problem in remaining floors above f-th floor
                int c2 = dpTwo[numFloors - f];
                // Worst case, it takes Math.max(c1, c2) moves
                min = Math.min(min, 1 + Math.max(c1, c2));
            }
            return min;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1884EggDropWith2EggsAndNFloors().new Solution();
        
    } 
}