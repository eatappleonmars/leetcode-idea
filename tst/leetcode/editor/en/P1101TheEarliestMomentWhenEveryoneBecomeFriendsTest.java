package leetcode.editor.en;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1101TheEarliestMomentWhenEveryoneBecomeFriendsTest {

    P1101TheEarliestMomentWhenEveryoneBecomeFriends.Solution sol = new P1101TheEarliestMomentWhenEveryoneBecomeFriends().new Solution();
    
    @Test
    public void test3() {
        int[][] logs = {{9, 3, 0}, {0, 2, 1}, {8, 0, 1}, {1, 3, 2}, {2, 2, 0}, {3, 3, 1}};
        int n = 4;
        assertEquals(2, sol.earliestAcq(logs, n));
    }

    @Test
    public void test4() {
        int[][] logs = {{9, 0, 3}, {0, 2, 7}, {12, 3, 1}, {5, 5, 2}, {3, 4, 5}, {1, 5, 0}, {6, 2, 4}, {2, 5, 3}, {7, 7, 3}};
        int n = 8;
        assertEquals(-1, sol.earliestAcq(logs, n));
    }
}