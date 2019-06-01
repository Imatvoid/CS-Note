package leetcode.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseLinkedListII {


    public ListNode reverseBetween(ListNode head, int m, int n) {


        int m1 =m;
        ListNode res = new ListNode(0);
        res.next = head;
        head = res;

        int count  = n-m;

        ListNode pre = head;
        while(m1-->0){
            pre = head;
            head = head.next;
        }
        ListNode start = head;

        while(count-->0){
            head = head.next;
        }
        ListNode end = head;


        ListNode temp = end.next;
        end.next=null;

        pre.next=reverseList(start);
        start.next=temp;

        return res.next;


    }



    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while(head!=null){
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

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            line = in.readLine();
            int m = Integer.parseInt(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            ListNode ret = new ReverseLinkedListII().reverseBetween(head, m, n);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
