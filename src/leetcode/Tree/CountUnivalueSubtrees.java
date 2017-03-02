package leetcode.Tree;

/**
 * Created by qifu on 17/3/2.
 */
public class CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }
    private boolean helper(TreeNode root, int[] count){
        if(root == null) return true;
        boolean left = helper(root.left, count);
        boolean right = helper(root.right, count);
        if(left && right) {
            if(root.left != null && root.val != root.left.val) {
                return false;
            }
            if(root.right != null && root.val != root.right.val) {
                return false;
            }

            count[0]++;
            return true;
        }
        return false;
    }
}
