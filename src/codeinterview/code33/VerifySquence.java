package codeinterview.code33;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/16
 * Time: 10:13
 */
public class VerifySquence {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) return false;
        //数组最后一个为根节点
        int root = sequence[sequence.length - 1];
        //搜索比根节点小的作为左子树
        int low = 0;
        while (sequence[low] < root) low++;
        //搜索比根节点大的作为右子树
        int high = low;
        for (; high < sequence.length - 1; high++)
            if (sequence[high] < root) return false;
        boolean left = true;
        if (low > 0) {
            int[] leftSequence = new int[low];
            for (int i = 0; i < low; i++) leftSequence[i] = sequence[i];
            left = VerifySquenceOfBST(leftSequence);
        }
        boolean right = true;
        if (high < sequence.length - 1) {
            int[] rightSequence = new int[sequence.length - low - 1];
            for (int i = 0; i < sequence.length - low - 1; i++) rightSequence[i] = sequence[low++];
        }
        return (left && right);
    }
}
