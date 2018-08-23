package codeinterview.code53;

/**
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 */

public class GetNumberOfK {

    //递归写法
    private int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return getFirstK(array, k, start, mid - 1);
        } else if (array[mid] < k) {
            return getFirstK(array, k, mid + 1, end);
        } else if (mid - 1 >= 0 && array[mid - 1] == k) {
            return getFirstK(array, k, start, mid - 1);
        } else {
            return mid;
        }
    }

    //循环写法
    private int getLastK(int[] array, int k, int start, int end) {
        int length = array.length;
        int mid = (start + end) >> 1;
        while (start <= end) {
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else if (mid + 1 < length && array[mid + 1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }

    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0) return 0;
        int start = getFirstK(array, k, 0, array.length - 1);
        int end = getLastK(array, k, 0, array.length - 1);
        if (start != -1 && end != -1) {
            return end - start + 1;
        }
        return 0;
    }
}
