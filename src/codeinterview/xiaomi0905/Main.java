package codeinterview.xiaomi0905;

public class Main {
    //偶数在前
    public int[] adjust(int[] arr) {
        if (arr.length == 0 || arr.length == 1) return arr;
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            while (low < high & arr[low] % 2 == 0) low++;
            while (low < high & arr[high] % 2 != 0) high--;
            int tmp = arr[low];
            arr[low] = arr[high];
            arr[high] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        for (int i:new Main().adjust(arr)){
            System.out.println(i);
        }
    }
}
