package leetcode.Tree;

import java.util.Stack;

/**
 * Created by qifu on 17/5/16.
 */
public class SubtreeofAnotherTree {

    //traversal
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(helper(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public boolean helper(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;

        if(s.val != t.val) {
            return false;
        }
        return (helper(s.left, t.left) && helper(s.right, t.right));
    }

    //preorder 拉直树,生成字符串,查看子树生成的字符串是否在s生成的字符串中
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String _s = generator(s);
        String _t = generator(t);
        return _s.contains(_t);
    }
    public String generator(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur == null) {
                sb.append(",#");
            } else {
                sb.append("," + cur.val);
                stack.push(cur.left);
                stack.push(cur.right);
            }
        }
        return sb.toString();
    }

}
