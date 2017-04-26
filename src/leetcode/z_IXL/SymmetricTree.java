package leetcode.z_IXL;

import leetcode.DPandBackTracking.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 17/4/22.
 */
public class SymmetricTree {
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    //O(n)
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return right == left;
        if((left.val == right.val) && helper(left.left, right.right) && helper(left.right, right.left)) return true;
        else return false;
    }

    //interative O(n)
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return true;
        queue.add(root.left);
        queue.add(root.right);
        while(queue.size() > 1) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
