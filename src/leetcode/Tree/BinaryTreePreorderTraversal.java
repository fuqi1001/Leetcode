package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qifu on 16/9/30.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        addNode(result,root);
        return result;
    }
    public void addNode(List<Integer> list , TreeNode node){
        if(node == null) return;
        list.add(node.val);
        addNode(list,node.left);
        addNode(list,node.right);
    }



    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return result;
    }
}
