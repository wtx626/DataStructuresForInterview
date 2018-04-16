package codeinterview.code36;

import codeinterview.common.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/16
 * Time: 17:38
 */
public class Convert {
    TreeNode leftHead = null;
    TreeNode rightHead = null;

    /**
     * 使用中序遍历构建双向链表
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Convert(pRootOfTree.left);
        if (rightHead == null) {
            rightHead = leftHead = pRootOfTree;
        } else {
            //将右节点向后移动
            rightHead.right = pRootOfTree;
            pRootOfTree.left = rightHead;
            rightHead = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return leftHead;
    }
}
