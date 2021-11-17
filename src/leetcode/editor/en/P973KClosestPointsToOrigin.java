//Given an array of points where points[i] = [xi, yi] represents a point on the 
//X-Y plane and an integer k, return the k closest points to the origin (0, 0). 
//
// The distance between two points on the X-Y plane is the Euclidean distance (
//i.e., √(x1 - x2)² + (y1 - y2)²). 
//
// You may return the answer in any order. The answer is guaranteed to be 
//unique (except for the order that it is in). 
//
// 
// Example 1: 
//
// 
//Input: points = [[1,3],[-2,2]], k = 1
//Output: [[-2,2]]
//Explanation:
//The distance between (1, 3) and the origin is sqrt(10).
//The distance between (-2, 2) and the origin is sqrt(8).
//Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//We only want the closest k = 1 points from the origin, so the answer is just [
//[-2,2]].
// 
//
// Example 2: 
//
// 
//Input: points = [[3,3],[5,-1],[-2,4]], k = 2
//Output: [[3,3],[-2,4]]
//Explanation: The answer [[-2,4],[3,3]] would also be accepted.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= points.length <= 10⁴ 
// -10⁴ < xi, yi < 10⁴ 
// 
// Related Topics Array Math Divide and Conquer Geometry Sorting Heap (Priority 
//Queue) Quickselect 👍 4125 👎 177


package leetcode.editor.en;

// 2021-11-16 09:30:31

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;

public class P973KClosestPointsToOrigin {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {



        public int[][] kClosest(int[][] points, int k) {
//            return solveWithArraySort(points, k);
            return solveWithHeap(points, k);
        }

        private int[][] solveWithArraySort(int[][] points, int k) {
            final Function<int[], Integer> sqDistanceFunc = (point) -> {

            };
            Arrays.sort(points, Comparator.comparing(sqDistanceFunc));
            return Arrays.copyOfRange(points, 0, k);
        }

        private int[][] solveWithHeap(int[][] points, int k) {
            Queue<int[]> maxHeap = new PriorityQueue<>(k, (p1, p2) -> {
                return sqDistance(p2) - sqDistance(p1);
            });

            for (int[] point : points) {
                maxHeap.offer(point);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }

            int[][] result = new int[k][];
            for (int i = 0; i < k; i++) {
                int[] point = maxHeap.poll();
                result[i] = point;
            }
            return result;
        }

        private int sqDistance(int[] point) {
            return point[0] * point[0] + point[1] * point[1];
        };
    }

    //leetcode submit region end(Prohibit modification and deletion)


    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P973KClosestPointsToOrigin().new Solution();

        final int[][] points1 = {{1,3}, {-2,2}};
        final int k1 = 1;
        printPoints(sol.kClosest(points1, k1));

        final int[][] points2 = {{3,3}, {5,-1}, {-2,4}};
        final int k2 = 2;
        printPoints(sol.kClosest(points2, k2));
    }

    private static String printPoint(int[] point) {
        return("[" + point[0] + ", " + point[1] + "]");
    }

    private static void printPoints(int[][] points) {
        for (int[] point : points) {
            System.out.print(printPoint(point) + ", ");
        }
        System.out.println();
    }
}