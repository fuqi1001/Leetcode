package leetcode.Tree;

import java.util.*;

/**
 * Created by qifu on 16/9/8.
 */

public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        result.push(Collections.singletonList(root.val));
        queue.add(root);
        while(!queue.isEmpty()){
            List<TreeNode> list = new ArrayList<>(queue);
            List<Integer> temp = new ArrayList<>();
            queue.clear();
            for(TreeNode node : list){
                TreeNode left = node.left;
                TreeNode right = node.right;
                if(left != null){
                    temp.add(left.val);
                    queue.add(left);
                }
                if(right != null){
                    temp.add(right.val);
                    queue.add(right);
                }
            }

            result.push(temp);
        }
        result.pop();
        return result;
    }

    //
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return res;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> cur = new ArrayList<>();
            while(size-- > 0){
                TreeNode node = queue.poll();
                cur.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(0, cur);
        }
        return res;
    }

    //
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, root, 0);
        return res;
    }
    public void helper(List<List<Integer>> res, TreeNode root, int height){
        if(root == null) return;
        if(height >= res.size()){
            res.add(0, new LinkedList<>());
        }
        helper(res, root.left, height + 1);
        helper(res, root.right, height + 1);
        res.get(res.size() - height - 1).add(root.val);
    }
}
