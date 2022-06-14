//You have n dice and each die has k faces numbered from 1 to k. 
//
// Given three integers n, k, and target, return the number of possible ways (
//out of the kⁿ total ways) to roll the dice so the sum of the face-up numbers 
//equals target. Since the answer may be too large, return it modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: n = 1, k = 6, target = 3
//Output: 1
//Explanation: You throw one die with 6 faces.
//There is only one way to get a sum of 3.
// 
//
// Example 2: 
//
// 
//Input: n = 2, k = 6, target = 7
//Output: 6
//Explanation: You throw two dice, each with 6 faces.
//There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
// 
//
// Example 3: 
//
// 
//Input: n = 30, k = 30, target = 500
//Output: 222616187
//Explanation: The answer must be returned modulo 10⁹ + 7.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n, k <= 30 
// 1 <= target <= 1000 
// 
// Related Topics Dynamic Programming 👍 2026 👎 86


package leetcode.editor.en;

// 2022-06-09 21:44:20

public class P1155NumberOfDiceRollsWithTargetSum {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numRollsToTarget(int n, int k, int target) {

            if (target < n || target > n * k) {
                return 0;
            }

            int m = 1_000_000_007;

            // dp[t] corresponds to the number of combinations given t
            long[] dp = new long[target + 1];
            // Initialize dp for rolling the dice once
            for (int i = 1; i < dp.length && i <= k; i++) {
                dp[i] = 1;
            }
            // For each roll r starting from the second time
            for (int r = 2; r <= n; r++) {
                // Calculate range
                int max = Math.min(r * k, target); // roll k for r times, but max <= target
                // Traverse local target t in descending order as we still need smaller dp values
                for (int t = max; t >= 0; t--) {
                    // Reset dp[t] because it contains number of combinations when rolling dice for (r-1) times,
                    // but now we need to update the count when rolling dice for (r) times. Reset to recalculate.
                    // Example:
                    //  Given standard dice and target is 1.
                    //  When rolling once, count is 1
                    //  When rolling twice, impossible to reach target 1, so it's 0
                    dp[t] = 0;
                    // Count all permutations
                    for (int diceValue = 1; diceValue <= k && t >= diceValue; diceValue++) {
                        dp[t] = (dp[t] + dp[t - diceValue]) % m;
                    }
                }
            }

//    [
//            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 30, 465, 4960, 40920, 278256, 1623160, 8347680, 38608020, 163011640, 635745396, 311801426, 898654871, 518731105, 378959814, 911615453, 626418448, 695014617, 648093714, 847815693, 527148437, 445591511, 260234861, 327487510, 306534915, 462115415, 323705681, 597315486, 144535089, 289070178, 368504652, 261621062, 61202912, 508804095, 618302762, 10222117, 123722890, 624693051, 884740225, 646130201, 803065159, 164978823, 632033327, 963669454, 957773431, 766336931, 285925483, 914761387, 76363307, 269521595, 897854691, 141757014, 236601961, 16490132, 337518823, 496893311, 889369486, 477841275, 759905955, 301527873, 405749228, 306764502, 133734061, 546959149, 82594327, 397274479, 81514647, 476122337, 263339790, 863667573, +401
//            more]
            return (int) dp[target];
        }
    }

//    class Solution {
//        int mod = 1_000_000_007;
//        public int numRollsToTarget(int d, int f, int target) {
//            long[] dp = new long[target + 1];
//            dp[0] = 1;
//            for (int i = 1; i <= d; i++) {
//                for (int j = target; j >= 0; j--) {
//                    dp[j] = 0;
//                    for (int k = 1; k <= f; k++) {
//                        if (j >= k) {
//                            dp[j] = (dp[j] + dp[j - k]) % mod;
//                        } else {
//                            break;
//                        }
//                    }
//                }
//            }
//            return (int)dp[target];
//        }
//    }

    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1155NumberOfDiceRollsWithTargetSum().new Solution();
        
    } 
}