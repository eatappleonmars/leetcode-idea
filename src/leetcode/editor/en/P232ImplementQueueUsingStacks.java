//Implement a first in first out (FIFO) queue using only two stacks. The 
//implemented queue should support all the functions of a normal queue (push, peek, pop, 
//and empty). 
//
// Implement the MyQueue class: 
//
// 
// void push(int x) Pushes element x to the back of the queue. 
// int pop() Removes the element from the front of the queue and returns it. 
// int peek() Returns the element at the front of the queue. 
// boolean empty() Returns true if the queue is empty, false otherwise. 
// 
//
// Notes: 
//
// 
// You must use only standard operations of a stack, which means only push to 
//top, peek/pop from top, size, and is empty operations are valid. 
// Depending on your language, the stack may not be supported natively. You may 
//simulate a stack using a list or deque (double-ended queue) as long as you use 
//only a stack's standard operations. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyQueue", "push", "push", "peek", "pop", "empty"]
//[[], [1], [2], [], [], []]
//Output
//[null, null, null, 1, 1, false]
//
//Explanation
//MyQueue myQueue = new MyQueue();
//myQueue.push(1); // queue is: [1]
//myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
//myQueue.peek(); // return 1
//myQueue.pop(); // return 1, queue is [2]
//myQueue.empty(); // return false
// 
//
// 
// Constraints: 
//
// 
// 1 <= x <= 9 
// At most 100 calls will be made to push, pop, peek, and empty. 
// All the calls to pop and peek are valid. 
// 
//
// 
// Follow-up: Can you implement the queue such that each operation is amortized 
//O(1) time complexity? In other words, performing n operations will take overall 
//O(n) time even if one of those operations may take longer. 
// Related Topics Stack Design Queue 👍 3260 👎 220


package leetcode.editor.en;

// 2022-04-27 10:32:09

import java.util.Deque;
import java.util.LinkedList;

public class P232ImplementQueueUsingStacks {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {

        private final Deque<Integer> inputStack, outputStatck;

        public MyQueue() {
            this.inputStack = new LinkedList<>();
            this.outputStatck = new LinkedList<>();
        }

        public void push(int x) {
            this.inputStack.offerFirst(x);
        }

        public int pop() {
            if (outputStatck.isEmpty()) {
                transfer();
            }
            return outputStatck.pollFirst();
        }

        public int peek() {
            if (outputStatck.isEmpty()) {
                transfer();
            }
            return outputStatck.peekFirst();
        }

        public boolean empty() {
            return inputStack.isEmpty() && outputStatck.isEmpty();
        }

        private void transfer() {
            while (!inputStack.isEmpty()) {
                outputStatck.offerFirst((inputStack.pollFirst()));
            }
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    //leetcode submit region end(Prohibit modification and deletion)
}