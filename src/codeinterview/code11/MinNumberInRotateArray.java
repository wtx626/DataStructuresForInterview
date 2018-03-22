package codeinterview.code11;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/3/22
 * Time: 15:29
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (array[low] >= array[high]) {
            if (high - low == 1) {
                mid = high;
                break;
            }
            mid = (low + high) / 2;
            if (array[mid] >= array[low]) {
                low = mid;
            }
            if (array[mid] <= array[high]) {
                high = mid;
            }
        }
        return array[mid];
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(arr));
    }
}
