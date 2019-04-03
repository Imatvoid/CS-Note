package linkedlist;

public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean res = false;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                res = true;
                break;
            }
        }

        return res;
    }


}
