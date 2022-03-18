//Android devices have a special lock screen with a 3 x 3 grid of dots. Users 
//can set an "unlock pattern" by connecting the dots in a specific sequence, 
//forming a series of joined line segments where each segment's endpoints are two 
//consecutive dots in the sequence. A sequence of k dots is a valid unlock pattern if 
//both of the following are true: 
//
// 
// All the dots in the sequence are distinct. 
// If the line segment connecting two consecutive dots in the sequence passes 
//through the center of any other dot, the other dot must have previously appeared 
//in the sequence. No jumps through the center non-selected dots are allowed.
// 
// For example, connecting dots 2 and 9 without dots 5 or 6 appearing 
//beforehand is valid because the line from dot 2 to dot 9 does not pass through the center 
//of either dot 5 or 6. 
// However, connecting dots 1 and 3 without dot 2 appearing beforehand is 
//invalid because the line from dot 1 to dot 3 passes through the center of dot 2. 
// 
// 
// 
//
// Here are some example valid and invalid unlock patterns: 
//
// 
//
// 
// The 1st pattern [4,1,3,6] is invalid because the line connecting dots 1 and 3
// pass through dot 2, but dot 2 did not previously appear in the sequence. 
// The 2nd pattern [4,1,9,2] is invalid because the line connecting dots 1 and 9
// pass through dot 5, but dot 5 did not previously appear in the sequence. 
// The 3rd pattern [2,4,1,3,6] is valid because it follows the conditions. The 
//line connecting dots 1 and 3 meets the condition because dot 2 previously 
//appeared in the sequence. 
// The 4th pattern [6,5,4,1,9,2] is valid because it follows the conditions. 
//The line connecting dots 1 and 9 meets the condition because dot 5 previously 
//appeared in the sequence. 
// 
//
// Given two integers m and n, return the number of unique and valid unlock 
//patterns of the Android grid lock screen that consist of at least m keys and at 
//most n keys. 
//
// Two unlock patterns are considered unique if there is a dot in one sequence 
//that is not in the other, or the order of the dots is different. 
//
// 
// Example 1: 
//
// 
//Input: m = 1, n = 1
//Output: 9
// 
//
// Example 2: 
//
// 
//Input: m = 1, n = 2
//Output: 65
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 9 
// 
// Related Topics Dynamic Programming Backtracking 👍 85 👎 76


package leetcode.editor.en;

// 2022-03-16 22:16:10

import java.util.HashSet;
import java.util.Set;

public class P351AndroidUnlockPatterns {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean[][] visited = new boolean[3][3];

        public int numberOfPatterns(int m, int n) {

            int count = 0;

            count += dfs(0, 0, 1, 0, m, n) * 4;
            count += dfs(0, 1, 1, 0, m, n) * 4;
            count += dfs(1, 1, 1, 0, m, n);

            return count;
        }

        private int dfs(int currRow, int currCol, int currLen, int count, int m, int n) {

            if (currLen > n) {
                return count;
            }

            if (currLen >= m) {
                count++;
            }

            this.visited[currRow][currCol] = true;

            for (int nextRow = 0; nextRow < 3; nextRow++) {
                for (int nextCol = 0; nextCol < 3; nextCol++) {

                    if (visited[nextRow][nextCol]) {
                        continue;
                    }

                    int rowDistance = Math.abs(currRow - nextRow);
                    int colDistance = Math.abs(currCol - nextCol);
                    int manhattanDistance = rowDistance + colDistance;

                    if ((rowDistance > 1 || colDistance > 1) && manhattanDistance != 3) {
                        int midRow = (nextRow + currRow) / 2;
                        int midCol = (nextCol + currCol) / 2;
                        if (!visited[midRow][midCol]) {
                            continue;
                        }
                    }

                    count = dfs(nextRow, nextCol, currLen+ 1, count, m, n);
                }
            }
            // backtrack
            this.visited[currRow][currCol] = false;

            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P351AndroidUnlockPatterns().new Solution();
        
    } 
}