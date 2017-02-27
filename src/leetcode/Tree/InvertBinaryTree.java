package leetcode.Tree;

/**
 * Created by qifu on 17/2/27.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        return helper(root);
    }

    public TreeNode helper(TreeNode node){
        if(node == null) return node;
        TreeNode left = node.left;
        node.left = helper(node.right);
        node.right = helper(left);
        return node;
    }

    //

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if(cur.left != null){
                stack.push(cur.left);
            }
            if(cur.right != null){
                stack.push(cur.right);
            }
        }
        return root;
    }
}
