package leetcode.Tree;

import java.util.Stack;

/**
 * Created by qifu on 16/12/1.
 */
public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(root == null) return 0;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                sum += root.left.val;
            }else{
                sum += sumOfLeftLeaves(root.left);
            }
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public int sumOfLeftLeaves(TreeNode root){
        int sum = 0;
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.left != null){
                if(cur.left.left == null && cur.left.right == null){
                    sum += cur.left.val;
                }else{
                    stack.push(cur.left);
                }
            }

            if(cur.right != null){
                if(cur.right.left != null || cur.right.right != null){
                    stack.push(cur.right);
                }
            }
        }
        return sum;
    }
}
