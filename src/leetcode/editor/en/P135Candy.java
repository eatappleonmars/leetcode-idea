//There are n children standing in a line. Each child is assigned a rating 
//value given in the integer array ratings. 
//
// You are giving candies to these children subjected to the following 
//requirements: 
//
// 
// Each child must have at least one candy. 
// Children with a higher rating get more candies than their neighbors. 
// 
//
// Return the minimum number of candies you need to have to distribute the 
//candies to the children. 
//
// 
// Example 1: 
//
// 
//Input: ratings = [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1, 
//2 candies respectively.
// 
//
// Example 2: 
//
// 
//Input: ratings = [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2, 
//1 candies respectively.
//The third child gets 1 candy because it satisfies the above two conditions.
// 
//
// 
// Constraints: 
//
// 
// n == ratings.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= ratings[i] <= 2 * 10⁴ 
// 
//
// Related Topics Array Greedy 👍 5722 👎 389


package leetcode.editor.en;

// 2023-07-09 10:27:16

import java.util.Arrays;
import java.util.List;

public class P135Candy {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int candy(int[] ratings) {
            if (ratings.length == 1) {
                return 1;
            }
//            return sol1(ratings);
            return sol2(ratings);
        }

        private int sol2(int[] ratings) {
            int n = ratings.length;
            int[] candies = new int[n];
            candies[0] = 1;
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                } else {
                    candies[i] = 1;
                }
            }
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
                // No need to consider the remaining conditions because candies[i] >= 1 already
            }
            return Arrays.stream(candies).sum();
        }

        // This is my own solution, the idea is similar to the approach 4 in
        // https://leetcode.com/problems/candy/editorial/?envType=study-plan-v2&envId=top-interview-150
        private int sol1(int[] ratings) {
            int n = ratings.length;
            int[] candies = new int[n];
            // lt & rt are indexes of the local minimum
            int lt = 0; // The first element in the array is treated as local minimum
            for (int rt = 1; rt < n; rt++) {
                // Reach right boundary
                if (rt == n - 1) { // The last element in the array is treated as local minimum
                    sol1Helper(ratings, candies, lt, n - 1);
                    break;
                }
                // Found local minimum
                if (ratings[rt] < ratings[rt - 1] && ratings[rt] <= ratings[rt + 1]) {
                    sol1Helper(ratings, candies, lt, rt);
                    lt = rt; // update lt
                }
            }
            return Arrays.stream(candies).sum();
        }

        private void sol1Helper(int[] ratings, int[] candies, int lt, int rt) {
            candies[lt] = 1;
            candies[rt] = 1;
            // From left to right, mono increase
            for (int i = lt + 1; i <= rt; i++) {
                int currRating = ratings[i];
                int ltRating = ratings[i - 1];
                if (currRating < ltRating) { // Past local maximum
                    break;
                }
                if (currRating == ltRating) { // This does not violate the rule.
                    candies[i] = 1;
                } else {
                    candies[i] = candies[i - 1] + 1;
                }
            }
            // From right to left, also mono increase
            for (int j = rt - 1; j >= lt; j--) {
                int currRating = ratings[j];
                int rtRating = ratings[j + 1];
                if (currRating < rtRating) { // Past local maximum
                    break;
                }
                // When traversing from right to left, need to take the max.
                if (currRating == rtRating) {
                    candies[j] = Math.max(candies[j], 1);
                } else {
                    candies[j] = Math.max(candies[j], candies[j + 1] + 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P135Candy().new Solution();
        
    } 
}