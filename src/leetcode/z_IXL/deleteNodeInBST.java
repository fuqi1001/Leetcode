package leetcode.z_IXL;

/**
 * Created by qifu on 17/4/22.
 */
public class deleteNodeInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //recursive
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode next_right = root.right;
            while(next_right.left != null) {
                next_right = next_right.left;
            }
            next_right.left = root.left;
            return root.right;
        }
        return root;
    }
    /*
    Recursively find the node that has the same value as the key,
    then setting the left/right nodes equal to the returened subtree

    Once the node is found, have to hadle 4 case

        node doesn't have left or right subtree, return null;
        node only has the left subtree, return left subtree;
        node only has the right subtree, return right subtree;
        node has both left and right subtree, find the minimum value in the right subtree
        append key node's left child to the minimum node, return key node's right child
     */

    //iterative  Time O(h), space O(1)
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null && cur.val != key) {
            pre = cur;
            if(key < cur.val) {
                cur = cur.left;
            } else if(key > cur.val){
                cur = cur.right;
            }
        }
        if(pre == null) {
            return deleteRootNode(cur);
        }
        if(pre.left == cur) {
            pre.left = deleteRootNode(cur);
        } else {
            pre.right = deleteRootNode(cur);
        }
        return root;
    }

    private TreeNode deleteRootNode(TreeNode root) {
        if(root == null) return null;
        if(root.left == null) {
            return root.right;
        }
        if(root.right == null) {
            return root.left;
        }

        TreeNode next = root.right;
        TreeNode pre = null;
        while(next.left !=null) {
            pre = next;
            next = next.left;
        }
        next.left = root.left;
        if(root.right != next) {
            pre.left = next.right;
            next.right = root.right;
        }
        return next;
    }
}
