package leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 17/6/17.
 */
public class AddOneRowtoTree {
    //iterative
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode new_root = new TreeNode(v);
            new_root.left = root;
            return new_root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while(++level < d) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode temp_left = cur.left;
            TreeNode temp_right = cur.right;
            cur.left = new TreeNode(v);
            cur.left.left = temp_left;
            cur.right = new TreeNode(v);
            cur.right.right = temp_right;
        }
        return root;
    }
    //recursive
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        return preOrder(root, v, d, 1, 0);
    }

    private TreeNode preOrder(TreeNode root, int v, int d, int level, int direction) {
        if (d == level) {
            TreeNode newNode = new TreeNode(v);
            if (direction == 0) {
                newNode.left = preOrder(root, v, d, level + 1, 0);
            }
            else {
                newNode.right = preOrder(root, v, d, level + 1, 1);
            }
            return newNode;
        }

        if (root == null) return null;

        root.left = preOrder(root.left, v, d, level + 1, 0);
        root.right = preOrder(root.right, v, d, level + 1, 1);

        return root;
    }
}
