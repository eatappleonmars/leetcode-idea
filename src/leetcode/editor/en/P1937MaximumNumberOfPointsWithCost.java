//You are given an m x n integer matrix points (0-indexed). Starting with 0 
//points, you want to maximize the number of points you can get from the matrix. 
//
// To gain points, you must pick one cell in each row. Picking the cell at 
//coordinates (r, c) will add points[r][c] to your score. 
//
// However, you will lose points if you pick a cell too far from the cell that 
//you picked in the previous row. For every two adjacent rows r and r + 1 (where 0 
//<= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will 
//subtract abs(c1 - c2) from your score. 
//
// Return the maximum number of points you can achieve. 
//
// abs(x) is defined as: 
//
// 
// x for x >= 0. 
// -x for x < 0. 
// 
//
// 
// Example 1: 
//
// 
//Input: points = [[1,2,3],[1,5,1],[3,1,1]]
//Output: 9
//Explanation:
//The blue cells denote the optimal cells to pick, which have coordinates (0, 2)
//, (1, 1), and (2, 0).
//You add 3 + 5 + 3 = 11 to your score.
//However, you must subtract abs(2 - 1) + abs(1 - 0) = 2 from your score.
//Your final score is 11 - 2 = 9.
// 
//
// Example 2: 
//
// 
//Input: points = [[1,5],[2,3],[4,2]]
//Output: 11
//Explanation:
//The blue cells denote the optimal cells to pick, which have coordinates (0, 1)
//, (1, 1), and (2, 0).
//You add 5 + 3 + 4 = 12 to your score.
//However, you must subtract abs(1 - 1) + abs(1 - 0) = 1 from your score.
//Your final score is 12 - 1 = 11.
// 
//
// 
// Constraints: 
//
// 
// m == points.length 
// n == points[r].length 
// 1 <= m, n <= 10⁵ 
// 1 <= m * n <= 10⁵ 
// 0 <= points[r][c] <= 10⁵ 
// 
// Related Topics Array Dynamic Programming 👍 921 👎 43


package leetcode.editor.en;

// 2021-12-21 09:31:01

// Time: O(mn)
// Space: O(mn)
public class P1937MaximumNumberOfPointsWithCost {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxPoints(int[][] points) {
            final int m = points.length;;
            final int n = points[0].length;
            long[][] dp = new long[m][n];

            // Initialize first row in dp
            for (int j = 0; j < n; j++) {
                dp[0][j] = points[0][j];
            }

            for (int i = 1; i < m; i++) {
                // dp[i][j] = points[i][j] - j + max(dp[i-1][k] + k), for k <= j
                long max1 = Integer.MIN_VALUE;
                for (int j = 0; j < n; j++) {
                    max1 = Math.max(max1, dp[i-1][j] + j);
                    dp[i][j] = points[i][j] - j + max1;
                }
                // dp[i][j] = points[i][j] + j + max(dp[i-1][k] - k), for k >= j
                long max2 = Integer.MIN_VALUE;
                for (int j = n -1; j >= 0; j--) {
                    max2 = Math.max(max2, dp[i-1][j] - j);
                    dp[i][j] = Math.max(dp[i][j], points[i][j] + j + max2);
                }
            }

            long res = 0;
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dp[m-1][j]);
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P1937MaximumNumberOfPointsWithCost().new Solution();
        
    } 
}