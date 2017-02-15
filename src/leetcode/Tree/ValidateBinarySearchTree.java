package leetcode.Tree;

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
}
