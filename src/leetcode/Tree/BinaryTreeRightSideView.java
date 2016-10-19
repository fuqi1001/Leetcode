package leetcode.Tree;

import java.util.*;

/**
 * Created by qifu on 16/10/18.
 */
public class BinaryTreeRightSideView {
    //level order traversal get last element each level
    //bfs
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return new ArrayList<>();
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ;i++){
                TreeNode node = queue.poll();
                if(i == size - 1){
                    res.add(node.val);
                }

                if(node.left!= null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
    //===============
    public List<Integer> rightSideView(TreeNode root){
        List<List<TreeNode>> result = new ArrayList<>();
        if(root != null) helper(result,root,0);
        List<Integer> res = new ArrayList<>();
        int size = result.size();
        for(int i = 0 ; i < size ;i++){
            List<TreeNode> list = new ArrayList<>();
            list = result.get(i);
            res.add(list.get(list.size() - 1).val);
        }
        return res;
    }
    public void helper(List<List<TreeNode>> result,TreeNode root, int height){
        if(root == null) return ;
        if(height >= result.size()){
            result.add(result.add(new ArrayList<TreeNode>()););
        }
        result.get(height).add(root);
        if(root.left != null) helper(result,root.left,height+1);
        if(root.right != null) helper(result,root.right,height+1);
    }





    //dfs
    int maxDepth = 0;
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root){
        result = new LinkedList<>();
        if(root!= null) helper(root,1);
        return result;
    }
    public void helper(TreeNode root, int depth){
        if(depth > maxDepth){
            maxDepth = depth;
            result.add(root.val);
        }
        if(root.right != null) helper(root.right,depth+1);
        if(root.left != null) helper(root.left,depth+1);
    }
}
