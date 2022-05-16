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
// Return true if you can finish all courses. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0. So it is possible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you 
//should also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// All the pairs prerequisites[i] are unique. 
// 
// Related Topics Depth-First Search Breadth-First Search Graph Topological 
//Sort 👍 9282 👎 376


package leetcode.editor.en;

// 2022-05-16 09:01:20

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P207CourseSchedule {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // Clear logic when using class but has poor performance
//        class CourseRequirement {
//            int courseId;
//            int preSize = 0;
//            List<CourseRequirement> next = new ArrayList<>();
//
//            CourseRequirement(int courseId) {
//                this.courseId = courseId;
//            }
//        }

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // Define graph using List and array for better performance.
            // Use class for clearer logic instead.
            int[] preCourseSizes = new int[numCourses];
            List<List<Integer>> nextCoursesGraph = new ArrayList<>(numCourses);
            // Initialize graph
            for (int courseId = 0; courseId < numCourses; courseId++) {
                nextCoursesGraph.add(courseId, new ArrayList<>());
            }
            // Build graph
            for (int[] prerequisite : prerequisites) {
                int courseId = prerequisite[0];
                int preCourseId = prerequisite[1];
                preCourseSizes[courseId]++;
                nextCoursesGraph.get(preCourseId).add(courseId);
            }
            // BFS
            Queue<Integer> allowed = new LinkedList<>();
            for (int id = 0; id < numCourses; id++) {
                if (preCourseSizes[id] == 0) {
                    allowed.offer(id);
                }
            }

            int count = 0;
            while (!allowed.isEmpty()) {
                count++;
                List<Integer> nextCourseIds = nextCoursesGraph.get(allowed.poll());
                for (int nextCourseId : nextCourseIds) {
                    preCourseSizes[nextCourseId]--;
                    if (preCourseSizes[nextCourseId] == 0) {
                        // Expand BFS queue
                        allowed.offer(nextCourseId);
                    }
                }
            }

            return count == numCourses;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P207CourseSchedule().new Solution();
        
    } 
}