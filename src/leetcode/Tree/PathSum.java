package leetcode.Tree;

import java.util.Stack;

/**
 * Created by qifu on 16/9/15.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root,0,sum);
    }

    public boolean hasPathSum(TreeNode node, int sum, int target){
        if(node == null) return false;
        sum += node.val;
        if(node.left == null  && node.right ==null){
            if(sum == target) return true;
            else return false;
        }

        return hasPathSum(node.left,sum,target) || hasPathSum(node.right,sum,target);

    }

    //
    public boolean hasPathSum(TreeNode root, int sum){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return (root.val == sum);
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    //
    public boolean hasPathSum(TreeNode root, int sum){
        if(root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty() && root != null){
            TreeNode cur = stack.pop();
            if(cur.left == null && cur.right == null){
                if(cur.val == sum) return true;
            }

            if(cur.right != null){
                cur.right.val = cur.val + cur.right.val;
                stack.push(cur.right);
            }
            if(cur.left != null){
                cur.left.val = cur.val + cur.left.val;
                stack.push(cur.left);
            }
        }
        return false;
    }
}
