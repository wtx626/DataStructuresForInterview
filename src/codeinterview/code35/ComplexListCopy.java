package codeinterview.code35;

import codeinterview.common.RandomListNode;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/16
 * Time: 14:34
 */
public class ComplexListCopy {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode cur = pHead;
        //复制节点
        while (cur != null) {
            RandomListNode tmp = new RandomListNode(cur.label);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        //设置随机指针
        cur = pHead;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //拆分链表
        RandomListNode cloneHead = pHead.next;
        RandomListNode cloneCur = cloneHead;
        cur = pHead;
        while (cur != null) {
            cur.next = cur.next.next;
            if (cloneCur.next != null)
                cloneCur.next = cloneCur.next.next;
            cur = cur.next;
            cloneCur = cloneHead.next;
        }
        return cloneHead;
    }
}
