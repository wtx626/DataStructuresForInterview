package codeinterview.code06;

import codeinterview.common.ListNode;

import java.util.ArrayList;
import java.util.Stack;


public class PrintListReversing {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList();
        Stack<Integer> stack = new Stack();
        ListNode p = listNode;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        while (!stack.empty()) {
            result.add(stack.pop());
        }

        return result;
    }
}
