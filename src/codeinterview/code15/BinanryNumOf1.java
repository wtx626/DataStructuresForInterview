package codeinterview.code15;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/3/22
 * Time: 17:19
 */
public class BinanryNumOf1 {
    public int NumberOf1(int n) {
        int count=0;
        while(n!=0){
            count++;
            n = (n-1)&n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new BinanryNumOf1().NumberOf1(12));
    }
}
