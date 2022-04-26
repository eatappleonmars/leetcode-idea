package utils;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] values) {
        ListNode head = build(values);
        this.val = head.val;
        this.next = head.next;
    }

    public ListNode build(int[] values) {
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;

        for (int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummyHead.next;
    }

    public void print() {
        ListNode head = this;
        print(head);
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " - ");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
