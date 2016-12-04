package leetcode.Tree;

import leetcode.other.IntegerBreak;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qifu on 16/12/4.
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int res = helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return res;
    }

    private int helper(TreeNode root, int sum){
        if(root == null) return 0;
        int res = 0;
        if(sum == root.val) res++;

        res += helper(root.left, sum - root.val);
        res += helper(root.right, sum - root.val);

        return res;
    }


    ///https://discuss.leetcode.com/topic/64526/17-ms-o-n-java-prefix-sum-method

    public int pathSum(TreeNode root, int sum){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        return helper(root, 0, sum, map);
    }

    public int helper(TreeNode root, int sum, int target, Map<Integer, Integer> map){
        if(root == null) return 0;

        sum += root.val;
        int res = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        res += helper(root.left, sum, target, map) + helper(root.right, sum,  target, map);
        map.put(sum, map.get(sum) - 1);
        return res;
    }
}
