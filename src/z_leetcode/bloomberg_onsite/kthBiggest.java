package z_leetcode.bloomberg_onsite;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class kthBiggest {
    public int kthBiggest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            if(--k == 0) break;
            root = root.left;
        }
        return root.val;
    }
}
