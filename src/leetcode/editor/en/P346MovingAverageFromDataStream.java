//Given a stream of integers and a window size, calculate the moving average of 
//all integers in the sliding window. 
//
// Implement the MovingAverage class: 
//
// 
// MovingAverage(int size) Initializes the object with the size of the window 
//size. 
// double next(int val) Returns the moving average of the last size values of 
//the stream. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MovingAverage", "next", "next", "next", "next"]
//[[3], [1], [10], [3], [5]]
//Output
//[null, 1.0, 5.5, 4.66667, 6.0]
//
//Explanation
//MovingAverage movingAverage = new MovingAverage(3);
//movingAverage.next(1); // return 1.0 = 1 / 1
//movingAverage.next(10); // return 5.5 = (1 + 10) / 2
//movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
//movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= size <= 1000 
// -10⁵ <= val <= 10⁵ 
// At most 10⁴ calls will be made to next. 
// 
// Related Topics Array Design Queue Data Stream 👍 1272 👎 118


package leetcode.editor.en;

// 2022-05-05 21:53:33

import java.util.LinkedList;
import java.util.Queue;

public class P346MovingAverageFromDataStream {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class MovingAverage {

        private int sum;
        private int size;
        private Queue<Integer> queue;

        public MovingAverage(int size) {
            this.sum = 0;
            this.size = size;
            this.queue = new LinkedList<>();
        }

        public double next(int val) {
            sum += val;
            queue.offer(val);
            if (queue.size() > this.size) {
                sum -= queue.poll();
            }
            return sum / (double) queue.size();
        }
    }

    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P346MovingAverageFromDataStream().new Solution();
        
    } 
}