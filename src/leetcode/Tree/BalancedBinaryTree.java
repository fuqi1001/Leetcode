package leetcode.Tree;

/**
 * Created by qifu on 16/9/13.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root){
        if(root == null) return true;

        if(Math.abs(depth(root.left)-depth(root.right)) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + Math.max(depth(root.left) , depth(root.right));
    }

    /////////////////////////////////
    public boolean isBalanced(TreeNode root){
        if(root == null) return true;
        return height(root) != -1;
    }

    public int height(TreeNode node){
        if(node == null) return 0;

        int leftHeight = height(node.left);
        if(leftHeight == -1)
            return -1;
        int rightHeight = height(node.right);
        if(rightHeight == -1)
            return -1;

        if(leftHeight - rightHeight < -1 || leftHeight - rightHeight >1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
}
