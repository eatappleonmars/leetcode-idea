package leetcode.editor.en;

import org.junit.jupiter.api.Test;
import utils.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class P143ReorderListTest {

    P143ReorderList.Solution sol = new P143ReorderList().new Solution();

    @Test
    public void test1() {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4});
        head.print();
        sol.reorderList(head);

    }
}