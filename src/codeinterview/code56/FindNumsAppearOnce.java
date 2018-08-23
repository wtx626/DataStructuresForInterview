package codeinterview.code56;

/**
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
        }
        int sum = 0;
        for (int i : array) {
            sum ^= i;
        }
        String sumStr = Integer.toBinaryString(sum);
        for (int i : array) {
            if (((i >> (sumStr.length() - 1)) & 1) == 1) {
                num1[0] ^= i;
            } else {
                num2[0] ^= i;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[2];
        new FindNumsAppearOnce().FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0] + "\t" + num2[0]);
    }
}
