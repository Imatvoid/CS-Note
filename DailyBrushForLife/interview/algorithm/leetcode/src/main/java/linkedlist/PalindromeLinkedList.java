package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeLinkedList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        // 通常需要考虑的因素是0和1的情况
        if(head == null || head.next == null){
            return  false;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        int count = 0;
        //寻找中间节点    1 2 3 则为1  1 2 3 4  也为2
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }


//        //寻找中间节点    1 2 3 则为2  1 2 3 4  也为2
//        while (fast!=null ){
//            fast = (fast.next==null)?null:fast.next.next;
//            slow = slow.next;
//            count++;
//        }

        // 倒转中间后边的链表
        slow = reverseLinkedList(slow);

        fast = head;
        ListNode save = slow;
        boolean res = true;
        while (slow != null) {
            if (slow.val != fast.val) {
                res = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        reverseLinkedList(save);
        return res;


    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            boolean ret = new PalindromeLinkedList().isPalindrome(head);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
