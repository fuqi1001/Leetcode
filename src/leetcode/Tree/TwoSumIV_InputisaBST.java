package leetcode.Tree;

/**
 * Created by qifu on 17/8/6.
 */
public class TwoSumIV_InputisaBST {
    TreeNode head;

    public boolean findTarget(TreeNode root, int k) {
        if(root == null || (root.left == null && root.right == null)) return false;

        head = root;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            TreeNode cur = que.poll();
            if(help(head, k - cur.val) && (k-cur.val != cur.val)) {

                return true;
            }
            if(cur.left != null)  que.add(cur.left);
            if(cur.right != null) que.add(cur.right);
        }
        return false;
    }
    public boolean help(TreeNode root, int target) {

        TreeNode cur = root;
        while(cur != null) {
            if(cur.val == target){
                //System.out.println(cur.val+" "+target);
                return true;
            }

            if(target > cur.val) {
                if(cur.right == null) return false;
                cur = cur.right;
            } else if(target < cur.val){
                if(cur.left == null) return false;
                cur = cur.left;
            }
        }
        return false;
    }

    //
    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, root, k);
    }
    private boolean findTarget(TreeNode root, TreeNode node, int k) {
        if(node == null) return false;
        if(search(root, node, k - node.val)) {
            return true;
        }
        return findTarget(node.left, root, k) || findTarget(node.right, root, k);
    }
    private boolean search(TreeNode node, TreeNode excluded, int target) {
        if(node == null) return false;
        if(node.val == target) {
            return node != excluded;
        }
        else if(target < node.val) {
            return search(node.left, excluded, target);
        }
        else if(target > node.val) {
            return search(node.right, excluded, target);
        }
        return false;
    }
}
