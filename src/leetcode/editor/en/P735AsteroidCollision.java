//We are given an array asteroids of integers representing asteroids in a row. 
//
// For each asteroid, the absolute value represents its size, and the sign 
//represents its direction (positive meaning right, negative meaning left). Each 
//asteroid moves at the same speed. 
//
// Find out the state of the asteroids after all collisions. If two asteroids 
//meet, the smaller one will explode. If both are the same size, both will explode. 
//Two asteroids moving in the same direction will never meet. 
//
// 
// Example 1: 
//
// 
//Input: asteroids = [5,10,-5]
//Output: [5,10]
//Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never 
//collide.
// 
//
// Example 2: 
//
// 
//Input: asteroids = [8,-8]
//Output: []
//Explanation: The 8 and -8 collide exploding each other.
// 
//
// Example 3: 
//
// 
//Input: asteroids = [10,2,-5]
//Output: [10]
//Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide 
//resulting in 10.
// 
//
// Example 4: 
//
// 
//Input: asteroids = [-2,-1,1,2]
//Output: [-2,-1,1,2]
//Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving 
//right. Asteroids moving the same direction never meet, so no asteroids will meet 
//each other.
// 
//
// 
// Constraints: 
//
// 
// 2 <= asteroids.length <= 10⁴ 
// -1000 <= asteroids[i] <= 1000 
// asteroids[i] != 0 
// 
// Related Topics Array Stack 👍 2778 👎 210


package leetcode.editor.en;

// 2021-11-27 11:16:53

import java.util.Arrays;

public class P735AsteroidCollision {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            int top = 0; // mimic top of stack
            for (int i = 1; i < asteroids.length; i++) {
                top = handle(asteroids, top, asteroids[i]);
            }
            return Arrays.copyOf(asteroids, top + 1);
        }

        private boolean sameDirection(int a1, int a2) {
            return ((a1 >> 31) ^ (a2 >> 31)) == 0;
        }

        private int handle(int[] stack, int top, int incomingAsteroid) {
            // In case of empty stack, or same direction, or will never meet, simply push to stack
            if (top == -1 || sameDirection(stack[top], incomingAsteroid) || incomingAsteroid > 0) {
                top++;
                stack[top] = incomingAsteroid;
                return top;
            }
            // otherwise, if same size, cancel each other
            if (stack[top] == -incomingAsteroid) {
                top--;
                return top;
            }
            // compare size, incomingAsteroid must be negative
            if (-incomingAsteroid < stack[top]) { // incoming asteroid is smaller, bye
                return top;
            } else { // incoming asteroid is larger, keep popping the stack and check
                top--;
                return handle(stack, top, incomingAsteroid);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P735AsteroidCollision().new Solution();
        
    } 
}