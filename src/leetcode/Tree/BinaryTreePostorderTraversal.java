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



    //
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        TreeNode node = root;
        stack1.push(node);
        while(!stack1.isEmpty()) {
            TreeNode cur = stack1.pop();
            stack2.push(cur);
            if(cur.left != null) stack1.push(cur.left);
            if(cur.right != null) stack1.push(cur.right);
        }
        while(!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }
        return res;
    }

    /**
     * 后续遍历 左->右->中
     * 中->右->左
     * 然后用另一个stack 倒转一次
     * @param root
     * @return
     */



    //
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
