package codeinterview.code49;

/**
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber {

//    public boolean isUglyNumber(int n) {
//        while (n % 2 == 0) n /= 2;
//        while (n % 3 == 0) n /= 3;
//        while (n % 5 == 0) n /= 5;
//        return n == 1 ? true : false;
//    }
//
//    public int GetUglyNumber_Solution(int index) {
//        if (index <= 0) return 0;
//        int count = 0;
//        int cur = 0;
//        while (count < index) {
//            cur++;
//            if (isUglyNumber(cur)) count++;
//        }
//        return cur;
//    }

    public int GetUglyNumber_Solution(int index) {
        if (index == 0) return 0;
        int[] res = new int[index];
        res[0] = 1;
        int i2, i3, i5;
        i2 = i3 = i5 = 0;
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(res[i2] * 2, Math.min(res[i3] * 3, res[i5] * 5));
            if (res[i] == res[i2] * 2) i2++;
            if (res[i] == res[i3] * 3) i3++;
            if (res[i] == res[i5] * 5) i5++;
        }
        return res[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(new GetUglyNumber().GetUglyNumber_Solution(1500));
    }
}
