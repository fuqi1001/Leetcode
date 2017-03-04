package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/1/6.
 */
public class FindLeavesofBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();

        while(root != null){
            if(helper(root, leaves)) root = null;

            res.add(leaves);
            leaves = new ArrayList<>();
        }
        return res;
    }

    private boolean helper(TreeNode cur, List<Integer> leaves){
        if(cur.left == null && cur.right == null) {
            leaves.add(cur.val);
            return true;
        }

        if(cur.left != null) {
            if(helper(cur.left, leaves)){
                cur.left = null;
            }
        }

        if(cur.right != null) {
            if(helper(cur.right, leaves)){
                cur.right = null;
            }
        }

        return false;
    }

    //
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }
    private int height(TreeNode root, List<List<Integer>> res) {
        if(root == null) return -1;
        int level = 1 + Math.max(height(root.left, res), height(root.right, res));
        if(res.size() < level + 1) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        return level;
    }
}
