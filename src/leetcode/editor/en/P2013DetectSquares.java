//You are given a stream of points on the X-Y plane. Design an algorithm that: 
//
// 
// Adds new points from the stream into a data structure. Duplicate points are 
//allowed and should be treated as different points. 
// Given a query point, counts the number of ways to choose three points from 
//the data structure such that the three points and the query point form an axis-
//aligned square with positive area. 
// 
//
// An axis-aligned square is a square whose edges are all the same length and 
//are either parallel or perpendicular to the x-axis and y-axis. 
//
// Implement the DetectSquares class: 
//
// 
// DetectSquares() Initializes the object with an empty data structure. 
// void add(int[] point) Adds a new point point = [x, y] to the data structure. 
//
// int countOfSquares(int[] point) Counts the number of ways to form axis-aligned 
//squares with point point = [x, y] as described above. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["DetectSquares", "add", "add", "add", "countOfSquares", "countOfSquares", "add", "countOfSquares"]
//[[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 1
//0]]]
//Output
//[null, null, null, null, 1, 0, null, 2]
//
//Explanation
//DetectSquares detectSquares = new DetectSquares();
//detectSquares.add([3, 10]);
//detectSquares.add([11, 2]);
//detectSquares.add([3, 2]);
//detectSquares.countOfSquares([11, 10]); // return 1. You can choose:
//                               //   - The first, second, and third points
//detectSquares.countOfSquares([14, 8]);  // return 0. The query point cannot form a 
//square with any points in the data structure.
//detectSquares.add([11, 2]);    // Adding duplicate points is allowed.
//detectSquares.countOfSquares([11, 10]); // return 2. You can choose:
//                               //   - The first, second, and third points
//                               //   - The first, third, and fourth points
// 
//
// 
// Constraints: 
//
// 
// point.length == 2 
// 0 <= x, y <= 1000 
// At most 3000 calls in total will be made to add and countOfSquares. 
// 
// Related Topics Array Hash Table Design Counting 👍 154 👎 67


package leetcode.editor.en;

// 2021-12-16 09:19:32

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P2013DetectSquares {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class DetectSquares {

        private final int[][] countMap;
        private final Map<Integer, Set<Integer>> rowToColumnsMap;
        private final Map<Integer, Set<Integer>> columnToRowsMap;

        public DetectSquares() {
            this.countMap = new int[1001][1001];
            this.rowToColumnsMap = new HashMap<>();
            this.columnToRowsMap = new HashMap<>();
        }

        public void add(int[] point) {
            int thisRow = point[0];
            int thisCol = point[1];
            this.countMap[thisRow][thisCol]++;
            this.rowToColumnsMap.computeIfAbsent(thisRow, key -> new HashSet<>()).add(thisCol);
            this.columnToRowsMap.computeIfAbsent(thisCol, key -> new HashSet<>()).add(thisRow);
        }

        public int count(int[] point) {
            int thisRow = point[0];
            int thisCol = point[1];

            Set<Integer> rows = columnToRowsMap.get(thisCol);
            Set<Integer> cols = rowToColumnsMap.get(thisRow);
            
            if (rows == null || cols == null) {
                return 0;
            }

            int countOfSquares = 0;
            int count1 = 1;
            for (int row : rows) {
                if (row == thisRow) { // square length > 0
                    continue;
                }
                int count2 = countMap[row][thisCol];
                for (int col :cols) {
                    if (Math.abs(thisRow - row) != Math.abs(thisCol -  col)) { // must be square
                        continue;
                    }
                    int count3 = countMap[thisRow][col];
                    int count4 = countMap[row][col];
                    if (count4 != 0) {
                        countOfSquares += count1 * count2 * count3 * count4;
                    }

                }
            }
            return countOfSquares;
        }
    }

    /**
     * Your DetectSquares object will be instantiated and called as such:
     * DetectSquares obj = new DetectSquares();
     * obj.add(point);
     * int param_2 = obj.countOfSquares(point);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}