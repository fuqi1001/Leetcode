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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        TreeNode lastVisit = null;
        while(node!=null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }

            node = stack.peek();

            if(node.right == null || node.right == lastVisit){
                result.add(node.val);
                lastVisit = node;
                stack.pop();
                node = null;
            }
            else{
                node = node.right;
            }
        }
        return result;
    }

}
