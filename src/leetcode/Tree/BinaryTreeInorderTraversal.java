package leetcode.Tree;
import java.util.*;
import java.lang.*;


/**
 * Created by qifu on 16/4/4.
 */


public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
/*
*
* version one
* */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        while(node!=null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
    /*
    *
    * version two  拉直二叉树
    * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        TreeNode node = root;
        while(node != null){
            if(node.left == null){
                result.add(node.val);
                node = node.left;
            }
            else{
                TreeNode pre = node.left;
                while(pre.right != null && pre.right != node){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = node;
                    node = node.left;
                }
                else{
                    pre.left = null;
                    result.add(node.val);
                    node = node.right;
                }
            }
        }
        return result;

    }

    /*
    *
    * version three
    * */
    public  List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        addNode(result,root);
        return result;
    }
    private void addNode(List<Integer> result,TreeNode root){
        if(root == null) return;
        addNode(result,root.left);
        result.add(root.val);
        addNode(result,root.right);
    }



}


