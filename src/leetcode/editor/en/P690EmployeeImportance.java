//You have a data structure of employee information, including the employee's 
//unique ID, importance value, and direct subordinates' IDs. 
//
// You are given an array of employees employees where: 
//
// 
// employees[i].id is the ID of the iᵗʰ employee. 
// employees[i].importance is the importance value of the iᵗʰ employee. 
// employees[i].subordinates is a list of the IDs of the direct subordinates of 
//the iᵗʰ employee. 
// 
//
// Given an integer id that represents an employee's ID, return the total 
//importance value of this employee and all their direct and indirect subordinates. 
//
// 
// Example 1: 
//
// 
//Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
//Output: 11
//Explanation: Employee 1 has an importance value of 5 and has two direct 
//subordinates: employee 2 and employee 3.
//They both have an importance value of 3.
//Thus, the total importance value of employee 1 is 5 + 3 + 3 = 11.
// 
//
// Example 2: 
//
// 
//Input: employees = [[1,2,[5]],[5,-3,[]]], id = 5
//Output: -3
//Explanation: Employee 5 has an importance value of -3 and has no direct 
//subordinates.
//Thus, the total importance value of employee 5 is -3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= employees.length <= 2000 
// 1 <= employees[i].id <= 2000 
// All employees[i].id are unique. 
// -100 <= employees[i].importance <= 100 
// One employee has at most one direct leader and may have several subordinates.
// 
// The IDs in employees[i].subordinates are valid IDs. 
// 
// Related Topics Hash Table Depth-First Search Breadth-First Search 👍 1369 👎 
//1167


package leetcode.editor.en;

// 2021-12-03 09:35:30

import utils.Employee;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class P690EmployeeImportance {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    */

    class Solution {
        public int getImportance(List<Employee> employees, int id) {

            Map<Integer, Integer> map = new HashMap<>(); // <id : index>
            for (int i = 0; i < employees.size(); i++) {
                map.put(employees.get(i).id, i);
            }

            return sumImportance(id, map, employees);
        }

        private int sumImportance(int id, Map<Integer, Integer> map, List<Employee> employees) {
            int index = map.get(id);
            Employee employee = employees.get(index);

            int sum = employee.importance;;
            for (int subOrdinateId : employee.subordinates) {
                sum += sumImportance(subOrdinateId, map, employees);
            }

            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    /**
     * Test
     */
    public static void main(String[] args) {
        Solution sol = new P690EmployeeImportance().new Solution();
        
    } 
}