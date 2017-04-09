package leetcode.Tree;

/**
 * Created by qifu on 17/4/9.
 */
public class BinaryTreeLongestConsecutiveSequenceII {
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return res;
    }
    private int[] helper(TreeNode root) {
        if(root == null) return new int[]{0,0};
        int up = 1, down = 1;
        if(root.left != null) {
            int[] left = helper(root.left);
            if(root.val == root.left.val + 1) {
                down = left[1] + 1;
            } else if(root.val == root.left.val - 1) {
                up = left[0] + 1;
            }
        }
        if(root.right != null) {
            int[] right = helper(root.right);
            if(root.val == root.right.val + 1) {
                down = Math.max(down, right[1] + 1);
            } else if(root.val == root.right.val - 1) {
                up = Math.max(up, right[0] + 1);
            }
        }
        res = Math.max(res, up + down - 1);
        return new int[] {up, down};
    }
}
