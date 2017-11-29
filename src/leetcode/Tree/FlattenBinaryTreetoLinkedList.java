package leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by qifu on 16/10/26.
 */
public class FlattenBinaryTreetoLinkedList {
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(lastNode != null){
            lastNode.left = null;
            lastNode.right = root;
        }
        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);

    }
    //---dive conq
    public void flatten(TreeNode root) {
        helper(root);
    }
    private TreeNode helper(TreeNode root){
        if(root == null) return null;

        if(root.left == null && root.right == null) return root;

        if(root.left == null) return helper(root.right);

        if(root.right == null){
            root.right = root.left;
            root.left = null;
            return helper(root.right);
        }

        TreeNode leftTail = helper(root.left);
        TreeNode rightTail = helper(root.right);

        leftTail.right = root.right;
        root.right = root.left;
        root.left = null;
        return rightTail;
    }

    //

    public void flatten(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur.left != null) {
                TreeNode p = cur.left;
                while(p.right != null) {
                    p = p.right;
                }
                p.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            if(cur.right != null) stack.push(cur.right);
        }
    }

    //
    public void flatten(TreeNode root) {
        TreeNode move = root;
        while(move != null) {
            if(move.left != null) {
                TreeNode p = move.left;
                while(p.right != null) {
                    p = p.right;
                }
                p.right = move.right;
                move.right = move.left;
                move.left = null;
            }
            move = move.right;
        }
    }

    //
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left != null) flatten(root.left);
        if(root.right != null) flatten(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) {
            root = root.right;
        }
        root.right = temp;
    }
}
