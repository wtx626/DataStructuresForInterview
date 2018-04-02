package codeinterview.code24;

import codeinterview.common.ListNode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/2
 * Time: 14:36
 */
public class ReverseList {
    //使用头插法进行反转
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode resultList = new ListNode(0);
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = resultList.next;
            resultList.next = tmp;
        }
        return resultList.next;
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
        ListNode result = new ReverseList().ReverseList(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

