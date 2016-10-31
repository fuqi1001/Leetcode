package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/10/30.
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(res,root,sum,0,list);

        return res;
    }
    public void helper(List<List<Integer>> res, TreeNode node, int sum, int cur, List<Integer> list){
        if(node == null) return;

        if(node.left == null && node.right == null){
            if(sum == cur + node.val){
                list.add(node.val);
                res.add(new ArrayList(list));
                list.remove(list.size() - 1);
            }

        }
        list.add(node.val);
        helper(res,node.left,sum,cur+node.val,list);
        helper(res,node.right,sum,cur+node.val,list);
        list.remove(list.size() - 1);
    }
}
