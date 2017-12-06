package leetcode.Tree;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int[] res = {Integer.MIN_VALUE};
        maxPathUtil(root, res);
        return res[0];
    }

    public int maxPathUtil(TreeNode root, int[] res) {
        if(root == null) return 0;
        int left =  maxPathUtil(root.left, res);
        int right = maxPathUtil(root.right, res);

        // Max path for parent call of root. This path must
        // include at-most one child of root
        int max_single = Math.max(Math.max(left, right) + root.val, root.val);

        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, left + right + root.val);
        res[0] = Math.max(max_top, res[0]);
        return max_single;
    }
}
