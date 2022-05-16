//There are a total of numCourses courses you have to take, labeled from 0 to 
//numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
// 
//
// 
// For example, the pair [0, 1], indicates that to take course 0 you have to 
//first take course 1. 
// 
//
// Return the ordering of courses you should take to finish all courses. If 
//there are many valid answers, return any of them. If it is impossible to finish all 
//courses, return an empty array. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you 
//should have finished course 0. So the correct course order is [0,1].
// 
//
// Example 2: 
//
// 
//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you 
//should have finished both courses 1 and 2. Both courses 1 and 2 should be taken 
//after you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3
//].
// 
//
// Example 3: 
//
// 
//Input: numCourses = 1, prerequisites = []
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// All the pairs [ai, bi] are distinct. 
// 
// Related Topics Depth-First Search Breadth-First Search Graph Topological 
//Sort 👍 6605 👎 237


package leetcode.editor.en;

// 2022-05-12 09:44:26

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P210CourseScheduleIi {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // Define graph
            int[] preCourseSizes = new int[numCourses];
            List<List<Integer>> nextCourseIdsGraph = new ArrayList<>(numCourses);
            // Initialize graph
            for (int courseId = 0; courseId < numCourses; courseId++) {
                nextCourseIdsGraph.add(new ArrayList<>());
            }
            // Build graph
            for (int[] prerequisite : prerequisites) {
                int courseId = prerequisite[0];
                int preCourseId = prerequisite[1];
                preCourseSizes[courseId]++;
                nextCourseIdsGraph.get(preCourseId).add(courseId);
            }
            // BFS
            int[] res = new int[numCourses];
            Queue<Integer> queue = new LinkedList<>();
            for (int courseId = 0; courseId < numCourses ; courseId++) {
                if (preCourseSizes[courseId] == 0) {
                    queue.offer(courseId);
                }
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int courseId = queue.poll();
                res[count] = courseId;
                count++;
                List<Integer> nextCourseIds = nextCourseIdsGraph.get(courseId);
                for (int nextCourseId : nextCourseIds) {
                    preCourseSizes[nextCourseId]--;
                    if (preCourseSizes[nextCourseId] == 0) {
                        queue.offer(nextCourseId);
                    }
                }
            }

            return count == numCourses ? res : new int[0];
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P210CourseScheduleIi().new Solution();
        
    } 
}