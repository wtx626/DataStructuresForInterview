package codeinterview.code42;

public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0 || array == null) return 0;
        int result = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0) {
                curSum = array[i];
            } else {
                curSum += array[i];
            }
            if (curSum > result)
                result = curSum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(new FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(input));
    }
}
