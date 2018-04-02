package codeinterview.code26;

import codeinterview.common.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/2
 * Time: 20:03
 */
public class HasSubtree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //使用先序递归遍历
        if (root1 != null && root2 != null) {
            //判断是否为子树
            if (root1.val == root2.val) {
                result = isSubTree(root1, root2);
            }
            if (!result) result = HasSubtree(root1.left, root2);
            if (!result) result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    public boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        //递归遍历左子树和右子树
        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }
}
