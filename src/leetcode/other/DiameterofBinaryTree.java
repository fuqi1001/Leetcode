package leetcode.other;

/**
 * Created by qifu on 17/3/18.
 */
public class DiameterofBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return 0;
        int cur = helper(root);
        return max - 1;
    }
    public int helper(TreeNode node) {
        if(node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);

        int cur = left + right + 1;
        max = Math.max(cur, max);

        return Math.max(left+1, right+1);

    }
}
