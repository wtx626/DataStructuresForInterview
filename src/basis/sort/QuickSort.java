package basis.sort;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/3/19
 * Time: 10:14
 */
public class QuickSort {
    /**
     * 对int型数组元素进行快排，使用递归
     * 空间复杂度：需要使用到递归工作栈来保存每一层递归调用必要的信息。最坏情况下:O(n)，最好情况下:lg(n+1)，平均:lg(n)
     * 时间复杂度：最坏情况下：O(n^2),最佳与平均时间接近:O(nlgn)
     *
     * @param arr  待排序数组
     * @param low  左指针
     * @param high 右指针
     */
    void quickSort(int arr[], int low, int high) {
        if (low < high) {
            //对数组arr进行划分操作，使arr[low->(pivot-1)]均小于枢纽值，arr[(pivot-1)->high]均大于枢纽值
            int pivot = partition(arr, low, high);
            //继续对两边同时使用快排
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    /**
     * 快速排序关键方法分区函数，使小于枢纽值的在左边，大于枢纽值的在右边，一般选取数组中第一个元素为枢纽值
     *
     * @param arr  待排序数组
     * @param low  左指针
     * @param high 右指针
     * @return 枢纽值的最终位置
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            //遍历找到第一个比枢纽值小的元素
            while (low < high && arr[high] >= pivot) high--;
            //将比枢纽值小的元素移到左边
            arr[low] = arr[high];
            //遍历找到第一个比枢纽值大的元素
            while (low < high && arr[low] <= pivot) low++;
            //将比枢纽值大的元素移到右边
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{25, 84, 21, 47, 15, 27, 68, 35};
        QuickSort quickSort = new QuickSort();
        //进行快速排序
        quickSort.quickSort(arr, 0, arr.length - 1);
        //打印排序之后的数组
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}
