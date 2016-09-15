package leetcode.Tree;

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
}
