//A super ugly number is a positive integer whose prime factors are in the 
//array primes. 
//
// Given an integer n and an array of integers primes, return the nᵗʰ super 
//ugly number. 
//
// The nᵗʰ super ugly number is guaranteed to fit in a 32-bit signed integer. 
//
// 
// Example 1: 
//
// 
//Input: n = 12, primes = [2,7,13,19]
//Output: 32
//Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 
//super ugly numbers given primes = [2,7,13,19].
// 
//
// Example 2: 
//
// 
//Input: n = 1, primes = [2,3,5]
//Output: 1
//Explanation: 1 has no prime factors, therefore all of its prime factors are 
//in the array primes = [2,3,5].
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁶ 
// 1 <= primes.length <= 100 
// 2 <= primes[i] <= 1000 
// primes[i] is guaranteed to be a prime number. 
// All the values of primes are unique and sorted in ascending order. 
// 
// Related Topics Array Hash Table Math Dynamic Programming Heap (Priority 
//Queue) 👍 1463 👎 278


package leetcode.editor.en;

// 2022-04-19 10:15:16

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P313SuperUglyNumber {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int nthSuperUglyNumber(int n, int[] primes) {

            int[] numbers = new int[n];
            numbers[0] = 1;

            // [ multiplication result, numberIndex, prime ]
            Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing(primeState -> primeState[0]));

            for (int prime : primes) {
                pq.offer(new int[]{prime, 0, prime});
            }

            for (int i = 1; i < n; i++) {
                int[] minPrimeState = pq.peek();
                numbers[i] = minPrimeState[0];
                //
                while (numbers[i] == pq.peek()[0]) {
                    int[] duplicateState = pq.poll();
                    duplicateState[1] += 1;
                    duplicateState[0] = duplicateState[2] * numbers[duplicateState[1]];
                    pq.offer(duplicateState);
                }
            }

            return numbers[n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P313SuperUglyNumber().new Solution();
        
    } 
}