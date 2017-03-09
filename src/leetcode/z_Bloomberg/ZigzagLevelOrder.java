package leetcode.z_Bloomberg;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qifu on 17/3/6.
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> next_level = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        boolean reverse = true;

        Stack<TreeNode> empty = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = stack.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = stack.pop();
                list.add(cur.val);
                if(reverse){
                    if(cur.left != null) next_level.push(cur.left);
                    if(cur.right != null) next_level.push(cur.right);
                } else {
                    if(cur.right != null) next_level.push(cur.right);
                    if(cur.left != null) next_level.push(cur.left);
                }
            }
            res.add(list);
            empty = stack;
            stack = next_level;
            next_level = empty;
            reverse = !reverse;
        }
        return res;
    }
    //
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>() ;
        if(root == null) return res;
        helper(root, res, 0);
        return res;
    }
    public void helper(TreeNode root, List<List<Integer>> res, int level) {
        if(root == null) return ;

        if(res.size() <= level) {
            res.add(new ArrayList<>());
        }
        if(level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }

    /*
    traverse的时候要同时把next指向下一个node
    其实就是将queue里面后一个的元素指向最前面那个就好
    */
}
