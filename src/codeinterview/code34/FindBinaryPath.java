package codeinterview.code34;

import codeinterview.common.TreeNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/4/16
 * Time: 11:54
 */
public class FindBinaryPath {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }
}
