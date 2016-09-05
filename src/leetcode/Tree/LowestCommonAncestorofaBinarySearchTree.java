package leetcode.Tree;

/**
 * Created by qifu on 16/9/5.
 */
public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        for(;;){
            if((p.val - root.val)*(q.val - root.val) <= 0) return root;
            if(p.val < root.val) root = root.left;
            else root = root.right;
        }
    }
}
