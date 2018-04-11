package codeinterview.code32;

import codeinterview.common.TreeNode;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/11
 * Time: 19:39
 */
public class PrintTree {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode front = queue.remove();
            result.add(front.val);
            if (front.left != null) queue.add(front.left);
            if (front.right != null) queue.add(front.right);
        }
        return result;
    }
}
