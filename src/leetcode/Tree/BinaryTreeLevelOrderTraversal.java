package leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qifu on 16/9/13.
 */
public class BinaryTreeLevelOrderTraversal {
    ///dfs
    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> result = new ArrayList<>();
        helper(result,root,0);
        return result;

    }

    public void helper(List<List<Integer>> result ,TreeNode root, int height){
        if(root == null) return;
        if(height >= result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(height).add(root.val);
        helper(result,root.left,height+1);
        helper(result,root.right,height+1);
    }

    ///bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result  = new ArrayList<>();

        if(root == null)
        return result;

        Queue<TreeNode> queue = new LinkedList<>();


        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;

    }

}
