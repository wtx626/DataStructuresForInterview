package codeinterview.code27;

import codeinterview.common.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/8
 * Time: 21:44
 */
public class MirrorTree {
    public void Mirror(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null) Mirror(root.left);
        if (root.right != null) Mirror(root.right);
    }
}
