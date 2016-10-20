package leetcode.Tree;

import java.util.Stack;

/**
 * Created by qifu on 16/10/19.
 */
public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode cur;

    public BSTIterator(TreeNode root) {
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (cur != null || !stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }

        cur = stack.pop();
        TreeNode node = cur;
        cur = cur.right;

        return node.val;
    }


    private Stack<TreeNode> stack ;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int res = node.val;
        if(node.right != null){
            node = node.right;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
        return res;
    }
}
