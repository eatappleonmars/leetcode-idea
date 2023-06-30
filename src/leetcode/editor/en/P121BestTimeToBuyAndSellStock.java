//You are given an array prices where prices[i] is the price of a given stock 
//on the iᵗʰ day. 
//
// You want to maximize your profit by choosing a single day to buy one stock 
//and choosing a different day in the future to sell that stock. 
//
// Return the maximum profit you can achieve from this transaction. If you 
//cannot achieve any profit, return 0. 
//
// 
// Example 1: 
//
// 
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you 
//must buy before you sell.
// 
//
// Example 2: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁴ 
// 
//
// Related Topics Array Dynamic Programming 👍 26287 👎 834


package leetcode.editor.en;

// 2023-06-29 22:14:39

public class P121BestTimeToBuyAndSellStock {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            return sol1(prices);
//            return sol2(prices);
        }

        private int sol1(int[] prices) {
            int profit = 0;
            int minBuyPrice = prices[0];
            for (int i = 1; i < prices.length; i++) {
                int sellPrice = prices[i];
                profit = Math.max(profit, sellPrice - minBuyPrice);
                minBuyPrice = Math.min(minBuyPrice, prices[i]);
            }
            return Math.max(profit, 0);
        }

        private int sol2(int[] prices) {
            if (prices.length == 1) {
                return 0;
            }
            int profit = 0;
            int maxSellPrice = prices[prices.length - 1];
            for (int i = prices.length-2; i >= 0; i--) {
                int buyPrice = prices[i];
                profit = Math.max(profit, maxSellPrice - buyPrice);
                maxSellPrice = Math.max(maxSellPrice, prices[i]);
            }
            return Math.max(profit, 0);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P121BestTimeToBuyAndSellStock().new Solution();
        
    } 
}