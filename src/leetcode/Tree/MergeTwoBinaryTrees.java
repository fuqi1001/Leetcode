package leetcode.Tree;

/**
 * Created by qifu on 17/6/11.
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }


    /// ??
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        if(t1 == null || t2 == null) return t1 == null ? t2 : t1;

        merge(t1, t2, null, true);
        return t1;
    }
    public void merge(TreeNode t1, TreeNode t2, TreeNode prev, boolean left) {
        if(t1 == null && t2 == null) return;
        if(t1 == null && t2 != null) {
            if(left) {
                prev.left = t2;
            } else {
                prev.right = t2;
            }
        }
        else if(t1 != null && t2 == null) {
            return;
        } else {
            t1.val += t2.val;
            merge(t1.left, t2.left, t1, true);
            merge(t1.right, t2.right, t1, false);
        }
    }
}
