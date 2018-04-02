package codeinterview.code22;

import codeinterview.common.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/2
 * Time: 11:22
 */
public class KthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head==null||k==0) return null;
        ListNode first = head, second;
        int count = 1;
        while (first.next != null) {
            if (count == k) break;
            first = first.next;
            count++;
        }
        if (count < k) return null;
        second = head;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.print(new KthToTail().FindKthToTail(l1, 6).val);
    }
}
