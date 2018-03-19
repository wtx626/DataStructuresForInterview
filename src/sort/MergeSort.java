package sort;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/3/19
 * Time: 14:52
 */
public class MergeSort {

    /**
     * arr[low->mid]和arr[mid+1->high]分别有序，merge将其合并为一个有序的数组
     * <p>
     * 空间复杂度：需要使用到临时数组用来拷贝排序后结果，O(n)
     * 时间复杂度：merge排序一次为O(n)，需进行lg(n)次，故为O(nlgn)
     *
     * @params low mid high 均为数组下标
     */
    private void merge(int arr[], int low, int mid, int high) {
        // 临时数组
        int[] tmp = new int[arr.length];
        int i, j, k;
        for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
            if (arr[i] <= arr[j]) tmp[k] = arr[i++];
            else tmp[k] = arr[j++];
        }
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= high) tmp[k++] = arr[j++];
        //将临时数组值拷贝回原数组
        for (int p = low; p <= high; p++) arr[p] = tmp[p];
    }

    /**
     * 递归进行2路归并排序，将数组划分为n/2个元素的子表，基于分治
     */
    private void mergeSort(int arr[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            //分解
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            //合并
            merge(arr, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{25, 84, 21, 47, 15, 27, 68, 35};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}
