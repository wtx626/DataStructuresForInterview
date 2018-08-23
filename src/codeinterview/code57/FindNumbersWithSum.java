package codeinterview.code57;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的两个数
 * <p>
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            if (array[low] + array[high] > sum) high--;
            else if (array[low] + array[high] < sum) low++;
            else {
                result.add(array[low]);
                result.add(array[high]);
                break;
            }
        }
        return (ArrayList<Integer>) result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 11, 15};
        new FindNumbersWithSum().FindNumbersWithSum(arr, 15).forEach(p -> System.out.println(p));
    }
}
