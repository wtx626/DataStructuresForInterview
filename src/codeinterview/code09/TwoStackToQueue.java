package codeinterview.code09;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/3/22
 * Time: 11:22
 */
public class TwoStackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.empty()) return stack2.pop();
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        TwoStackToQueue twoStackToQueue=new TwoStackToQueue();
        twoStackToQueue.push(1);
        twoStackToQueue.push(2);
        twoStackToQueue.push(3);
        System.out.println(twoStackToQueue.pop());
        System.out.println(twoStackToQueue.pop());
        twoStackToQueue.push(4);
        System.out.println(twoStackToQueue.pop());
        System.out.println(twoStackToQueue.pop());
    }
}
