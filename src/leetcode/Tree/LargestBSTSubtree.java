package leetcode.Tree;

/**
 * Created by qifu on 17/2/7.
 */
public class LargestBSTSubtree {
    class Result {
        int size;
        int lower;
        int upper;

        Result(int size, int lower, int upper){
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }

    int res = 0;

    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return res;
    }
    private Result helper(TreeNode root){
        if(root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Result left = helper(root.left);
        Result right = helper(root.right);

        if(left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new Result(-1, 0, 0);
        }

        int size = left.size + 1 + right.size;
        res = Math.max(size, res);
        return new Result(size, Math.min(root.val, left.lower), Math.max(root.val, right.upper));
    }
}
