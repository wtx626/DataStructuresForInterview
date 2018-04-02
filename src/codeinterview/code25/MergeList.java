package codeinterview.code25;

import codeinterview.common.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/2
 * Time: 19:24
 */
public class MergeList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null) return list2;
        if (list2==null) return list1;
        ListNode result = null;
        if (list1.val<list2.val){
            result=list1;
            result.next=Merge(list1.next,list2);
        }else {
            result=list2;
            result.next=Merge(list1,list2.next);
        }
        return result;
    }
}
