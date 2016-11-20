package leetcode.other;

import java.util.Stack;

/**
 * Created by qifu on 16/8/19.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        return (p.val == q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    //iterative
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        Stack<TreeNode> p1 = new Stack<>();
        Stack<TreeNode> q1 = new Stack<>();

        p1.push(p);
        q1.push(q);

        while(!p1.isEmpty() && !q1.isEmpty()){
            TreeNode rootp = p1.pop();
            TreeNode rootq = q1.pop();

            if(rootp.val != rootq.val) return false;
            if(rootp.left != null && rootq.left != null){
                p1.push(rootp.left);
                q1.push(rootq.left);
            }
            else{
                if(rootp.left != null && rootq.left == null) return false;
                if(rootp.left == null && rootq.left != null) return false;
            }

            if(rootp.right != null && rootq.right != null){
                p1.push(rootp.right);
                q1.push(rootq.right);
            }
            else{
                if(rootp.right != null && root.right == null) return false;
                if(rootq.right == null && root.right != null) return false;
            }
        }

        if(!p1.isEmpty() && q1.isEmpty()) return false;
        if(p1.isEmpty() && !q1.isEmpty()) return false;

        return true;
    }
}
