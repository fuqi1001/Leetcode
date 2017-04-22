package leetcode.z_IXL;

/**
 * Created by qifu on 17/4/22.
 */
public class mirrorTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //O(n)
    public boolean areMirror(TreeNode a, TreeNode b) {
        if(a == null && b == null) return true;

        if(a == null || b == null) return false;

        return a.val == b.val && areMirror(a.left, b.right) && areMirror(a.right, b.left);
    }
}
