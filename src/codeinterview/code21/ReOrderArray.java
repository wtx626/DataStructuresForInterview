package codeinterview.code21;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/2
 * Time: 10:57
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        if (array.length == 0) return;
        int low = 0, high = array.length - 1;
        while (low < high) {
            //找到偶数
            while (array[low] % 2 != 0) //奇数就一直向前移动
                low++;
            //找到奇数
            while (array[high] % 2 == 0)
                high--;
            //交换两个值
            if (low < high) {//low小于high时才交换
                int tmp = array[low];
                array[low] = array[high];
                array[high] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        new ReOrderArray().reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
