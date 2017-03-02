package leetcode.Tree;

/**
 * Created by qifu on 17/3/2.
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode next = null;
        TreeNode prev = null;
        TreeNode temp = null;
        while(cur != null) {
            next = cur.left;

            cur.left = temp;
            temp = cur.right;
            cur.right = prev;

            prev = cur;
            cur = next;
        }
        return prev;
    }

    //
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null) ) return root;
        TreeNode newNode = upsideDownBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return newNode;
    }
}
