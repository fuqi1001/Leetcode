package leetcode.z_IXL;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 17/4/22.
 */
public class mirrorTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //O(n)
    public boolean areMirror(TreeNode a, TreeNode b) {
        if(a == null && b == null) return true;

        if(a == null || b == null) return false;

        return a.val == b.val && areMirror(a.left, b.right) && areMirror(a.right, b.left);
    }
    /*
    For two tree 'a' and 'b' to be mirror tree, there must be 3 condition must be true
    1. the root node must be same
    2. left subtree of 'a' and 'b' must be mirror
    3. right subtree of 'a' and 'b' mush be mirror;
     easy to get a recursive way

     And we also can work this out with iterative way
     use a queue to keep the TreeNode
    First we put the root node to the queue,
    use while loop to go through these two tree
    everytime poll out the node from 'a' and 'b' and check are they equal
    or be null at the same time,
    if only one be null, thats mean these two are not mirror Tree

    after we check the current node, name as node_a and node_b
    we add node_a.left node_b.right node_a.right node_a.left to the queue
    to check the other node.

     */

    //iterator O(n)

    public boolean Mirror(TreeNode a, TreeNode b) {
        Queue<TreeNode> que = new LinkedList<>();
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        que.add(a);
        que.add(b);
        while(que.size() > 1) {
            TreeNode node_a = que.poll();
            TreeNode node_b = que.poll();

            if(node_a == null && node_b == null) continue;
            if(node_a == null || node_b == null) return false;
            if(node_a.val != node_b.val) return false;
            que.add(node_a.left);
            que.add(node_b.right);
            que.add(node_a.right);
            que.add(node_b.left);
        }
        return true;
    }
}
