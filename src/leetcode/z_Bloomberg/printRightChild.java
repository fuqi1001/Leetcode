package leetcode.z_Bloomberg;

import java.util.*;

/**
 * Created by qifu on 17/3/6.
 */
public class printRightChild {
    public static void print_right_Child(TreeNode root, int level) {
        if(root == null) return;
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) {
                    queue.add(cur.right);
                    if(height >= level)
                        list.add(cur.right);
                }
            }
            height++;

        }
        for(TreeNode r : list) {
            System.out.println(r.val);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        print_right_Child(root, 0);
    }
}
