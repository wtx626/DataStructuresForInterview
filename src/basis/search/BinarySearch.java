package basis.search;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/3/19
 * Time: 10:42
 */
public class BinarySearch {
    /**
     * 二分查找，仅适用于有序数组
     * 空间复杂度：由于不需要额外空间，O(1)
     * 时间复杂度：O(lgn)
     *
     * @param arr 有序数组
     * @param key 待查找关键字
     * @return 若key存在arr中，返回key在arr中的位置，否则返回-1
     */
    int binarySearch(int arr[], int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] < key) low = mid + 1;
            else if (arr[mid] > key) high = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = new int[]{21, 25, 27, 47, 35, 68};
        System.out.println(binarySearch.binarySearch(arr, 16));
        System.out.println(binarySearch.binarySearch(arr, 27));
    }
}
