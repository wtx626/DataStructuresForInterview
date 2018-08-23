package codeinterview.code40;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetMinKNum {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        List<Integer> result = new ArrayList<>();
        if (input.length < k) return (ArrayList<Integer>) result;
        PriorityQueue<Integer> inputQueue = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++) {
            inputQueue.add(input[i]);
        }
        for (int i = 0; i < k; i++) {
            result.add(inputQueue.poll());
        }
        return (ArrayList<Integer>) result;
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 10;
        for (Integer i : (new GetMinKNum()).GetLeastNumbers_Solution(input, k)) {
            System.out.println(i);
        }
    }
}
