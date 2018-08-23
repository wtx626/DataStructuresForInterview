package codeinterview.code55;

import codeinterview.common.TreeNode;

/**
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class AVLTree {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        TreeDepth treeDepth = new TreeDepth();
        int left = treeDepth.TreeDepth(root.left);
        int right = treeDepth.TreeDepth(root.right);
        int diff = right - left;
        if (diff > 1 || diff < -1) return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
}
