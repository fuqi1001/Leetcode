package leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> que = new LinkedList<>();
        Queue<Integer> count = new LinkedList<>();
        que.offer(root);
        count.offer(0);

        int max = 1;
        while(!que.isEmpty()) {
            int left = 0;
            int right = 0;
            int size = que.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                int index = count.poll();
                if(i == 0) {
                    left = index;
                }
                if(i == size - ){
                    right = index;
                }

                if(cur.left != null) {
                    que.offer(cur.left);
                    count.offer(2 * index);
                }
                if(cur.right != null) {
                    que.offer(cur.right);
                    count.offer(2 * index + 1);
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
