package leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 17/3/3.
 */
public class BinaryTreeLongestConsecutiveSequence {
    private int max = 0;

    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        int cur = 0;
        dfs(root, cur, root.val);
        return max;
    }
    public void dfs(TreeNode root, int cur, int target) {
        if(root == null) return ;

        if(root.val == target) {
            cur++;
        } else cur = 1;

        max = Math.max(max, cur);
        dfs(root.left, cur, root.val + 1);
        dfs(root.right, cur, root.val + 1);
    }

    //dfs without global

    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        return Math.max(dfs(root.left, 1, root.val), dfs(root.right, 1, root.val));
    }
    public int dfs(TreeNode root, int count, int val) {
        if(root == null) return count;
        count = (root.val - val == 1) ? count + 1 : 1;
        int left = dfs(root.left, count, root.val);
        int right = dfs(root.right, count, root.val);
        return Math.max(Math.max(left, right), count);
    }

    //bfs//false
    //[1,2,2,3,3,3,3,null,null,4]

    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = 1;
            TreeNode cur = queue.poll();
            while((cur.left != null && cur.left.val == cur.val + 1) || (cur.right != null && cur.right.val == cur.val + 1)) {
                if(cur.left != null && cur.left.val == cur.val + 1) {
                    if(cur.right != null) queue.offer(cur.right);
                    cur = cur.left;
                } else if(cur.right != null && cur.right.val == cur.val + 1) {
                    if(cur.left != null) queue.offer(cur.left);
                    cur = cur.right;
                }

                len++;
            }
            if(cur.left != null) queue.offer(cur.left);
            if(cur.right != null ) queue.offer(cur.right);
            res = Math.max(res, len);
        }
        return res;
    }
}
