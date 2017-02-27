package leetcode.Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by qifu on 17/2/27.
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int height = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            int size = stack.size();
            while(size-- > 0){
                TreeNode cur = stack.pop();
                if(cur.left != null){
                    stack.addLast(cur.left);
                }
                if(cur.right != null){
                    stack.addLast(cur.right);
                }
            }
            height++;
        }
        return height;
    }
}
