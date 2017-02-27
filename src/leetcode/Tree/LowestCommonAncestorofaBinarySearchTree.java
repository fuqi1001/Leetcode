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

    //
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
    //
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        while(true){
            if(root.val < min){
                root = root.right;
            } else if(root.val > max){
                root = root.left;
            } else {
                return root;
            }
        }
    }
}
