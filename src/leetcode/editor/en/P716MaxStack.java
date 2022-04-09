//Design a max stack data structure that supports the stack operations and 
//supports finding the stack's maximum element. 
//
// Implement the MaxStack class: 
//
// 
// MaxStack() Initializes the stack object. 
// void push(int x) Pushes element x onto the stack. 
// int pop() Removes the element on top of the stack and returns it. 
// int top() Gets the element on the top of the stack without removing it. 
// int peekMax() Retrieves the maximum element in the stack without removing it.
// 
// int popMax() Retrieves the maximum element in the stack and removes it. If 
//there is more than one maximum element, only remove the top-most one. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop",
// "top"]
//[[], [5], [1], [5], [], [], [], [], [], []]
//Output
//[null, null, null, null, 5, 5, 1, 5, 1, 5]
//
//Explanation
//MaxStack stk = new MaxStack();
//stk.push(5);   // [5] the top of the stack and the maximum number is 5.
//stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
//stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the 
//maximum, because it is the top most one.
//stk.top();     // return 5, [5, 1, 5] the stack did not change.
//stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is 
//different from the max.
//stk.top();     // return 1, [5, 1] the stack did not change.
//stk.peekMax(); // return 5, [5, 1] the stack did not change.
//stk.pop();     // return 1, [5] the top of the stack and the max element is 
//now 5.
//stk.top();     // return 5, [5] the stack did not change.
// 
//
// 
// Constraints: 
//
// 
// -10⁷ <= x <= 10⁷ 
// At most 10⁴ calls will be made to push, pop, top, peekMax, and popMax. 
// There will be at least one element in the stack when pop, top, peekMax, or 
//popMax is called. 
// 
//
// 
//Follow up: Could you come up with a solution that supports O(1) for each top 
//call and O(logn) for each other call? Related Topics Linked List Stack Design 
//Doubly-Linked List Ordered Set 👍 1453 👎 430


package leetcode.editor.en;

// 2022-04-09 15:17:40

import java.util.ArrayDeque;
import java.util.Deque;

public class P716MaxStack {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class MaxStack {

        private final Deque<Integer> valueStack;
        private final Deque<Integer> maxStack;

        public MaxStack() {
            this.maxStack = new ArrayDeque<>();
            this.valueStack = new ArrayDeque<>();
        }

        public void push(int x) {
            this.valueStack.offerFirst(x);
            this.maxStack.offerFirst(this.maxStack.isEmpty() ? x : Math.max(x, this.maxStack.peekFirst()));
        }

        public int pop() {
            this.maxStack.pollFirst();
            return this.valueStack.pollFirst();
        }

        public int top() {
            return this.valueStack.peekFirst();
        }

        public int peekMax() {
            return this.maxStack.peekFirst();
        }

        public int popMax() {

            final int max = peekMax();
            Deque<Integer> tempStack = new ArrayDeque<>();

            while (true) {
                int value = this.valueStack.pollFirst();
                this.maxStack.pollFirst(); // drop max info
                if (value == max) {
                    break;
                }
                tempStack.offerFirst(value); // transfer value
            }

            // Transfer back and rebuild max value info
            while (!tempStack.isEmpty()) {
                int value = tempStack.pollFirst();
                this.valueStack.offerFirst(value);
                this.maxStack.offerFirst(this.maxStack.isEmpty() ? value : Math.max(value, this.maxStack.peekFirst()));
            }

            return max;
        }
    }

    /**
     * Your MaxStack object will be instantiated and called as such:
     * MaxStack obj = new MaxStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.peekMax();
     * int param_5 = obj.popMax();
     */
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P716MaxStack().new Solution();
        
    } 
}