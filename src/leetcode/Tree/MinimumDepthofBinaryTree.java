package leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 16/9/16.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root){
        if(root == null) return 0;
        return helper(root);
    }
    public int helper(TreeNode root){
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null && root.right == null) return 1;
        return Math.min(helper(root.left),helper(root.right))+1;
    }


    ///

    public int minDepth(TreeNode root) {
        if(root == null) return 0 ;
        int h = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right == null) {
                    return h;
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            h++;
        }
        return h;
     }
}
