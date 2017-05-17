package leetcode.Tree;

/**
 * Created by Crino on 2017/5/16.
 */
public class BinaryTreeTilt {

    //post-order
    int res = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return res;
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        res += Math.abs(left - right);

        return left+right+root.val;
    }
}
