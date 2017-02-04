package leetcode.Tree;

import java.util.Stack;

/**
 * Created by qifu on 17/2/4.
 */
public class InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != p){
            stack.push(cur);

            if(cur.val > p.val){
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if(cur.right != null){
            cur = cur.right;
            while(cur.left != null){
                cur = cur.left;
            }
            return cur;
        } else {
            while(!stack.isEmpty() && stack.peek().val < cur.val){
                stack.pop();
            }
            return stack.isEmpty() ? null : stack.pop();

        }
    }
}
