package sort;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/3/19
 * Time: 11:46
 */
public class HeapSort {

    /**
     * 构建大顶堆
     */
    private void buildMaxHeap(int arr[]) {
        for (int i = arr.length / 2; i > 0; i--) {
            adjustDown(arr, i, arr.length);
        }
    }

    /**
     * 向下调整元素k的位置，使其满足大顶堆的定义
     * <p>
     * 循环比较k节点与子节点的大小，若k节点大于两个子节点，则不做变化；若k节点小于其中一个子节点，则向下调整
     *
     * @param arr
     * @param k   从第k个元素开始向下调整堆
     * @param len 需要调整的数组的长度，构建堆时len一直为arr.length，堆排序是len的长度为逐渐减少
     */
    private void adjustDown(int arr[], int k, int len) {
        //将第k个元素向下调整
        arr[0] = arr[k];
        for (int i = 2 * k; i < len; i *= 2) {
            if (i + 1 < len && arr[i] < arr[i + 1]) {
                i++; //取key的较大子节点
            }
            if (arr[0] >= arr[i]) break;
            else {
                //将arr[i]调整到双亲节点
                arr[k] = arr[i];
                //变换k的值
                k = i;
            }
        }
        arr[k] = arr[0];
    }

    /**
     * 交换数组中i和j对应的值
     *
     * @param arr 数组
     * @param i   第i个元素
     * @param j   第j个元素
     */
    private void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 堆排序
     * 依次将堆顶元素即arr[1]与最后一个元素交换，交换后重新构建大顶堆，数组的长度要减少一个
     */
    private void heapSort(int arr[]) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 1; i--) {
            swap(arr, i, 1);
            adjustDown(arr, 1, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 53, 17, 78, 9, 45, 65, 87, 32};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

}
