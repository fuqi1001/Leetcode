package leetcode.z_Bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qifu on 17/3/7.
 */
public class pathsum {
    //path sum 1
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return root.val == sum ;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    //path sum 2
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<Integer> list = new ArrayList<>();
        helper(root, res, list, 0, sum);
        return res;
    }

    public void helper(TreeNode root, List<List<Integer>> res, List<Integer> list, int sum, int target) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            sum += root.val;
            if(sum == target) {
                list.add(root.val);
                res.add(new ArrayList(list));
                list.remove(list.size() - 1);
            }
        }
        list.add(root.val);
        helper(root.left, res, list, sum + root.val, target);
        helper(root.right, res, list, sum + root.val, target);
        list.remove(list.size() - 1);
    }

    //path sum 3
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;

        int res = helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);

        return res;
    }
    public int helper(TreeNode root, int sum) {
        if(root == null) return 0;
        int res = 0;
        if(sum == root.val) res++;
        res += helper(root.left, sum - root.val);
        res += helper(root.right, sum - root.val);
        return res;
    }

    //
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        return helper(root, 0, sum, map);
    }
    private int helper(TreeNode root, int sum, int target, Map<Integer, Integer> map) {
        if(root == null) return 0;
        sum += root.val;
        int cur_path = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        cur_path += helper(root.left, sum, target, map) + helper(root.right, sum, target, map);
        map.put(sum, map.get(sum) - 1);
        return cur_path;
    }

}
