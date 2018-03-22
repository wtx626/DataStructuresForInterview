package codeinterview.code10;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/3/22
 * Time: 16:07
 */
public class JumpFloor {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * */
    public int jumpFloor(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        return jumpFloor(target-2)+jumpFloor(target-1);
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *数学归纳法：2^(target-1)
     * */
    public int jumpFloor2(int target) {
        if (target==0) return 0;
        return (int) Math.pow(2,target-1);
    }

    public static void main(String[] args) {
        System.out.println(new JumpFloor().jumpFloor2(1));
    }
}
