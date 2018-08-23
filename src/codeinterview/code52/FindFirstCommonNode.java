package codeinterview.code52;

import codeinterview.common.ListNode;

/**
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 */

public class FindFirstCommonNode {

    public int getListNodeLength(ListNode head) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = getListNodeLength(pHead1);
        int length2 = getListNodeLength(pHead2);
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        if (length1 < length2) {
            int tmpLen = length1;
            length1 = length2;
            length2 = tmpLen;
            ListNode tmpNode = p1;
            p1 = p2;
            p2 = tmpNode;
        }
        int dif = length1 - length2;
        int count = 0;
        while (count < dif) {
            p1 = p1.next;
            count++;
        }

        while (p1 != null && p2 != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
