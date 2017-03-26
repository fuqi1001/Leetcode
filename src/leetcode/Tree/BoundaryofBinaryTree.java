package leetcode.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qifu on 17/3/25.
 */
public class BoundaryofBinaryTree {
    int round;
    List<TreeNode> b_left;
    List<TreeNode> bottom;
    List<TreeNode> b_right;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return new ArrayList<>();
        round = 0;
        b_left = new ArrayList<>();
        bottom = new ArrayList<>();
        b_right = new ArrayList<>();

        b_left.add(root);
        if(root.left != null) find_left_boundary(root.left);

        find_bottom(root);

        if(root.right != null) find_right_boundary(root.right);
        Set<TreeNode> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(TreeNode node : b_left) {
            if(!set.contains(node)) res.add(node.val);
            set.add(node);
        }
        for(TreeNode node : bottom) {
            if(!set.contains(node)) res.add(node.val);
            set.add(node);
        }
        for(TreeNode node : b_right) {
            if(!set.contains(node)) res.add(node.val);
            set.add(node);
        }
        return res;
    }
    private void find_left_boundary(TreeNode root) {
        if(root == null) return;
        b_left.add(root);
        if(root.left != null) find_left_boundary(root.left);
        else find_left_boundary(root.right);
    }

    private void find_right_boundary(TreeNode root) {
        if(root == null) return;
        if(root.right != null) find_right_boundary(root.right);
        else find_right_boundary(root.left);
        b_right.add(root);
    }

    private void find_bottom(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) bottom.add(root);
        find_bottom(root.left);
        find_bottom(root.right);
    }
}
