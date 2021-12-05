package leetcode.editor.en;

import org.junit.jupiter.api.Test;
import utils.Employee;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P690EmployeeImportanceTest {
    private P690EmployeeImportance.Solution sol = new P690EmployeeImportance().new Solution();

    @Test
    public void test1() {
        Employee e1 = new Employee(101, 3, List.of());
        Employee e2 = new Employee(2,5, List.of(101));
        List<Employee> employees = List.of(e1, e2);
        assertEquals(8, sol.getImportance(employees, 2));
    }
}