package leetcode.Tree;

/**
 * Created by qifu on 16/12/30.
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        TreeNode kid = target < a ? root.left : root.right;

        if(kid == null) return a;

        int b = closestValue(kid, target);

        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }
    //  Iterative
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;

        while(root != null){
            if(Math.abs(closest - target) >= Math.abs(root.val - target)){
                closest = root.val;
            }

            root = target < root.val ? root.left : root.right;
        }

        return closest;
    }
}
