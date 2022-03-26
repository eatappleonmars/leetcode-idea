package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P721AccountsMergeTest {

    P721AccountsMerge.Solution sol = new P721AccountsMerge().new Solution();

    @Test
    public void test3() {
        List<List<String>> accounts = List.of(
                List.of("Alex", "Alex5@m.co", "Alex4@m.co", "Alex0@m.co"),
                List.of("Ethan", "Ethan3@m.co", "Ethan3@m.co", "Ethan0@m.co"),
                List.of("Kevin", "Kevin4@m.co", "Kevin2@m.co", "Kevin2@m.co"),
                List.of("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe2@m.co"),
                List.of("Gabe", "Gabe3@m.co", "Gabe4@m.co", "Gabe2@m.co")
        );

        List<List<String>> res = sol.accountsMerge(accounts);

        List<String> exp1 = List.of("Alex", "Alex0@m.co", "Alex4@m.co", "Alex5@m.co");
        List<String> exp2 = List.of("Ethan", "Ethan0@m.co", "Ethan3@m.co");
        List<String> exp3 = List.of("Gabe", "Gabe0@m.co", "Gabe2@m.co", "Gabe3@m.co", "Gabe4@m.co");
        List<String> exp4 = List.of("Kevin", "Kevin2@m.co", "Kevin4@m.co");

        assertTrue(res.contains(exp1));
        assertTrue(res.contains(exp2));
        assertTrue(res.contains(exp3));
        assertTrue(res.contains(exp4));
    }

    @Test
    public void test4() {
        List<List<String>> accounts = List.of(
                List.of("David", "David0@m.co", "David1@m.co"),
                List.of("David", "David3@m.co", "David4@m.co"),
                List.of("David", "David4@m.co", "David5@m.co"),
                List.of("David", "David2@m.co", "David3@m.co"),
                List.of("David", "David1@m.co", "David2@m.co")
        );

        List<List<String>> res = sol.accountsMerge(accounts);

        List<String> exp = List.of("David","David0@m.co","David1@m.co","David2@m.co","David3@m.co","David4@m.co","David5@m.co");

        assertEquals(1, res.size());
        assertEquals(exp, res.get(0));
    }
}