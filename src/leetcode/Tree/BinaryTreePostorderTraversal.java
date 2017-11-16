package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qifu on 16/9/30.
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        addNode(result, root);
        return result;
    }
    public void addNode(List<Integer> list, TreeNode node){
        if(node == null) return ;
        addNode(list, node.left);
        addNode(list,node.right);
        list.add(node.val);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return list;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return list;
    }

}
