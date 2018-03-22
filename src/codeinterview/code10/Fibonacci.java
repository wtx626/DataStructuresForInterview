package codeinterview.code10;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/3/22
 * Time: 15:58
 */
public class Fibonacci {
    /**
     * 采取从下往上计算
     */
    public int fibonacci(int n) {
        int f0 = 0;
        int f1 = 1;
        int sum = 0;
        if (n == 0) return 0;
        if (n == 1) return 1;
        for (int i = 2; i <= n; i++) {
            sum = f0 + f1;
            //向前进1
            f0 = f1;
            f1 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fibonacci(3));
    }
}
