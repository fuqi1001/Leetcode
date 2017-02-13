package leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 17/2/13.
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;
        int L = helper(root, 0);

        int res = 0;
        int level = 0;
        int num = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(new TreeNode(217783));


        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.val != 217783){
                //System.out.println(cur.val + " " + level +" " +num);
                num++;
                if(level == L && num == 1){
                    res = cur.val;
                    //System.out.println(res);
                    break;
                }
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            } else if(!queue.isEmpty()){
                level++;
                num = 0;
                queue.add(new TreeNode(217783));
            }
        }
        return res;
    }
    private int helper(TreeNode root, int level){
        if(root == null) return level;
        if(root.left != null || root.right != null){
            return Math.max(helper(root.left, level + 1), helper(root.right, level+ 1));
        } else return level;
    }


    ///
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(i == 0) res = cur.val;
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }

        return res;
    }
}
