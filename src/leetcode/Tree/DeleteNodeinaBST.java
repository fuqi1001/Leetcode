package leetcode.Tree;

/**
 * Created by qifu on 17/2/6.
 */
public class DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode sroot = root.right;
            while(sroot.left != null){
                sroot = sroot.left;
            }
            sroot.left = root.left;
            return root.right;
        }
        return root;
    }


    // iterative

    private TreeNode deleteRootNode(TreeNode root) {
        if(root == null) return null;
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;

        TreeNode next = root.right;
        TreeNode pre = null;
        while(next.left != null){
            pre = next;
            next = next.left;
        }

        next.left = root.left;
        /*if(root.right != next){
            pre.left = next.right;
            next.right = root.right;
        }*/

        return root.right;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;

        while(cur != null && cur.val != key) {
            pre = cur;
            if(key > cur.val) {
                cur = cur.right;
            } else if(key < cur.val) {
                cur = cur.left;
            }
        }

        if(pre == null){
            return deleteRootNode(cur);
        }
        if(pre.left == cur){
            pre.left = deleteRootNode(cur);
        } else {
            pre.right = deleteRootNode(cur);
        }
        return root;
    }
}
