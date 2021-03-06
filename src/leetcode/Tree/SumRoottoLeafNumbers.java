package leetcode.Tree;

import java.util.*;

/**
 * Created by qifu on 16/10/25.
 */
public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;

        return dfs(root,0);
    }

    public int dfs(TreeNode root, int prev){
        if(root == null){
            return 0;
        }
        int sum = root.val + prev * 10;
        if(root.left == null && root.right == null){
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }

    //bfs
    public int sumNumbers(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        int sum = 0;
        TreeNode cur = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur.left !=null){
                cur.left.val = cur.val*10+cur.left.val;
                queue.offer(cur.left);
            }
            if(cur.right != null){
                cur.right.val = cur.val * 10+cur.right.val;
                queue.offer(cur.right);
            }
            if(cur.right == null && cur.left == null) sum += cur.val;
        }
        return sum;
    }

    //dfs

    public int sumNumbers(TreeNode root){
        if(root == null) return 0;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = null;
        while(!stack.isEmpty()){
            cur = stack.pop();
            if(cur.right != null){
                cur.right.val = cur.val * 10 + cur.right.val;
                stack.push(cur.right);
            }
            if(cur.left != null){
                cur.left.val = cur.val * 10 + cur.left.val;
                stack.push(cur.left);
            }

            if(cur.left == null && cur.right == null) sum += cur.val;
        }
        return sum;
    }

    //
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        String str = "";
        List<String> list = new ArrayList<>();
        num(list, root, str);
        int sum = 0;

        for(String cur : list) {
            sum += Integer.valueOf(cur);
        }
        return sum;
    }
    public void num(List<String> list, TreeNode root, String str) {
        str = str + root.val;
        if(root.left == null && root.right == null) {
            list.add(str);
        }
        if(root.left != null) {
            num(list, root.left, str);
        }
        if(root.right != null) {
            num(list, root.right, str);
        }
    }



}
