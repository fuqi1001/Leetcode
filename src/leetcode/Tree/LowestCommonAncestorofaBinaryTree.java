package leetcode.Tree;

import java.util.*;

/**
 * Created by qifu on 16/11/8.
 */
public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parents.put(root,null);
        stack.push(root);

        while(!parents.containsKey(p)|| !parents.containsKey(q)){
            TreeNode node = stack.pop();
            if(node.left != null){
                parents.put(node.left, node);
                stack.push(node.left);
            }
            if(node.right != null){
                parents.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancestor = new HashSet<>();
        while(p != null){
            ancestor.add(p);
            p = parents.get(p);
        }
        while(!ancestor.contains(q)){
            q = parents.get(q);
        }

        return q;
    }

    //========================

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return left == null ? right : left;
    }
}
