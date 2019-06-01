package leetcode.linkedlist;

public class RemoveNthNodeFromEndofList {


    /**
     * 移除链表的倒数第K个节点
     * 双指针
     * 注意可能会移除头节点的情况
     * 注意空的判断
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        // consider remove the origin head
        ListNode p = new ListNode(-1);
        p.next = head;
        head = p;

        ListNode head1 = head;
        ListNode head2 = head;

        ListNode pre = null;
        int k = 1;
        while (head1 != null) {
            head1 = head1.next;
            k++;
            if (k > n + 1) {
                pre = head2;
                head2 = head2.next;
            }

        }
        // find
        pre.next = head2.next;
        return p.next;

    }
}
