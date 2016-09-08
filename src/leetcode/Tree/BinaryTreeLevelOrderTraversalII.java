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
}
