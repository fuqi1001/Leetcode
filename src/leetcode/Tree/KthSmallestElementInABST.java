package leetcode.Tree;

import java.util.Stack;

/**
 * Created by qifu on 16/10/11.
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k <= 0) return 0;
        TreeNode node = root;

        while(node!=null){
            if(node.left == null){
                if(k == 1){
                    return node.val;
                }
                k--;
                node = node.right;
            }
            else{
                TreeNode rightmost = node.left;
                while(rightmost.right !=null){
                    rightmost = rightmost.right;
                }

                TreeNode temp = node.left;
                node.left = null;
                rightmost.right = node;
                node = temp;
            }
        }
        return node.val;
    }

    //dfs binary search

    public int KthSmallest(TreeNode root, int k){
        int count = count_num(root.left);
        if(k <= count) {
            return KthSmallest(root.left, k);
        } else if(k > 1 + count){
            return KthSmallest(root.right, k - 1 - count);
        }
        return root.val;
    }
    public int count_num(TreeNode node){
        if(node == null) return 0;
        return 1 + count_num(node.left) + count_num(node.right);
    }

    //

    private int number;
    private int count;
    public int kthSmallest(TreeNode root, int k) {
        number = 0;
        count = k;
        helper(root);
        return number;
    }
    public void helper(TreeNode root) {
        if(root.left != null)  helper(root.left);

        count--;
        if(count == 0){
            number = root.val;
            return;
        }

        if(root.right != null)  helper(root.right);

    }

    //
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        while(k != 0){
            TreeNode cur = stack.pop();
            k--;
            if(k == 0) return cur.val;
            TreeNode right = cur.right;
            while(right != null){
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }
}
