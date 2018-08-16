package codeinterview.netease180811;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小易有一些立方体，每个立方体的边长为1，他用这些立方体搭了一些塔。现在小易定义：这些塔的不稳定值为它们之中最高的塔与最低的塔的高度差。小易想让这些塔尽量稳定，所以他进行了如下操作：每次从某座塔上取下一块立方体，并把它放到另一座塔上。注意，小易不会把立方体放到它原本的那座塔上，因为他认为这样毫无意义。现在小易想要知道，他进行了不超过k次操作之后，不稳定值最小是多少。
 * 输入描述:
 * 第一行两个数n,k(1<=n<=100,0<=k<=1000)表示塔的数量以及最多操作的次数。
 * 第二行n个数，ai(1<=ai <=104)表示第i座塔的初始高度。
 * <p>
 * <p>
 * 输出描述:
 * 第一行两个数s,m，表示最小的不稳定值和操作次数(m<=k)
 * 接下来m行，每行两个数x,y表示从第x座塔上取下一块立方体放到第y座塔上。
 * 示例1
 * 输入
 * 3 2
 * 5 8 5
 * 输出
 * 0 2
 * 2 1
 * 2 3
 */
public class Exam02 {


    static class Trace {
        private int from;
        private int to;

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }
    }

    public static int maxIndex(int[] a) {
        int max = a[0];
        int result = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                result = i;
            }
        }
        return result;
    }

    public static int minIndex(int[] a) {
        int min = a[0];
        int result = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Trace[] traces = new Trace[k];
        int count = 0;
        for (int i = 0; i < k; i++) {
            int maxIndex = maxIndex(a);
            int max = a[maxIndex];
            int minIndex = minIndex(a);
            int min = a[minIndex];
            if (max > min) {
                a[maxIndex]--;
                a[minIndex]++;
                traces[count] = new Trace();
                traces[count].setFrom(maxIndex + 1);
                traces[count].setTo(minIndex + 1);
                count++;
            } else {
                break;
            }
        }
        System.out.println((Arrays.stream(a).max().getAsInt() - Arrays.stream(a).min().getAsInt()) + "\t" + count);
        for (int i = 0; i < count; i++) {
            System.out.println(traces[i].getFrom() + "\t" + traces[i].getTo());
        }

    }
}
