package leetcode.Tree;

/**
 * Created by qifu on 16/9/16.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root){
        if(root == null) return 0;
        return helper(root);
    }
    public int helper(TreeNode root){
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null && root.right == null) return 1;
        return Math.min(helper(root.left),helper(root.right))+1;
    }
}