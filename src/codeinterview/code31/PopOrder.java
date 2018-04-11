package codeinterview.code31;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/11
 * Time: 17:27
 */
public class PopOrder {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0) return false;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < popA.length; ) {
            stack.push(pushA[i++]);
            while (j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
