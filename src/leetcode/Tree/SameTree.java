package leetcode.Tree;

/**
 * Created by qifu on 17/2/21.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return p == q;
        if(p.val != q.val ) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
