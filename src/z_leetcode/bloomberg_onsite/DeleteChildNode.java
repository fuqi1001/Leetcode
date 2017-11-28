package z_leetcode.bloomberg_onsite;


import java.util.LinkedList;
import java.util.Queue;

public class DeleteChildNode {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode deleteLeaveNode(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        root.left = deleteLeaveNode(root.left);
        root.right = deleteLeaveNode(root.right);
        return root;
    }


    //
    public TreeNode delete(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();
            while(size > 0) {
                TreeNode cur = que.poll();
                if(cur.left != null) {
                    if(cur.left.left == null && cur.left.right == null) cur.left = null;
                    else {
                        que.offer(cur.left);
                    }
                }
                if(cur.right != null) {
                    if(cur.right.left == null && cur.right.right == null) cur.right = null;
                    else {
                        que.offer(cur.right);
                    }
                }
                size--;
            }
        }
        return root;
    }
}
