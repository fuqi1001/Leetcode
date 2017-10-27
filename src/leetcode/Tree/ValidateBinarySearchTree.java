package leetcode.Tree;

import java.util.Stack;

/**
 * Created by qifu on 17/2/15.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    private boolean helper(TreeNode cur, Integer low, Integer high){
        if(cur == null) return true;
        return (low == null || cur.val > low)
                &&(high == null || cur.val < high)
                && helper(cur.left, low, cur.val)
                && helper(cur.right, cur.val, high);
    }

    //
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    public boolean helper(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if(min != null && min >= root.val) return false;
        if(max != null && max <= root.val) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    //
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
