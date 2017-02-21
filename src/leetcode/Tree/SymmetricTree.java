package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 16/9/13.
 */

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        if(root.left == null || root.right == null)
            return false;

        Queue<TreeNode> Qleft =new  LinkedList<TreeNode>();
        Queue<TreeNode> Qright = new LinkedList<TreeNode>();

        Qleft.add(root.left);
        Qright.add(root.right);

        while(!Qleft.isEmpty() && !Qright.isEmpty()){
            TreeNode left = Qleft.poll();
            TreeNode right = Qright.poll();

            if(left.val != right.val)
                return false;
            if((left.left == null && right.right != null) || (left.left!=null && right.right == null))
                return false;
            if((left.right ==null && right.left !=null) || (left.right != null && right.left ==null))
                return false;

            if(left.left != null && right.right!=null){
                Qleft.add(left.left);
                Qright.add(right.right);
            }

            if(left.right != null && right.left != null){
                Qleft.add(left.right);
                Qright.add(right.left);
            }
        }
        return true;
    }



    public boolean isSymmetricTree(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return left == right;

        return (left.val == right.val) && isSymmetricTree(left.left,right.right) && isSymmetricTree(left.right,right.left);
    }

    public boolean isSymmetric(TreeNode root){
        if(root == null) return true;

        return isSymmetricTree(root.left,root.right);
    }
}
