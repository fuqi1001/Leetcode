package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qifu on 16/10/29.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Stack<TreeNode> curlv = new Stack<>();
        Stack<TreeNode> nextlv = new Stack<>();
        Stack<TreeNode> empty = new Stack<>();
        boolean flag = true;

        curlv.push(root);

        while(!curlv.isEmpty()){
            List<Integer> curRes = new ArrayList<>();

            while(!curlv.isEmpty()){
                TreeNode node = curlv.pop();
                curRes.add(node.val);
                if(flag){
                    if(node.left != null){
                        nextlv.push(node.left);
                    }
                    if(node.right != null){
                        nextlv.push(node.right);
                    }
                }else{
                    if(node.right != null){
                        nextlv.push(node.right);
                    }
                    if(node.left != null){
                        nextlv.push(node.left);
                    }
                }
            }

            res.add(curRes);
            empty = curlv;
            curlv = nextlv;
            nextlv = empty;
            flag = !flag;
        }
        return res;
    }
}
