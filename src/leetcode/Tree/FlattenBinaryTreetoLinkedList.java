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

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right != null){
                stack.add(node.right);
            }
            if(node.left != null){
                stack.add(node.left);
            }

            node.left = null;
            if(stack.empty()){
                node.right = null;
            }else{
                node.right = stack.peek();
            }
        }
    }
}
