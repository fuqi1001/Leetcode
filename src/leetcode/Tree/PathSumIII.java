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

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return findPathSum(root, 0, sum, map);
    }
    private int findPathSum(TreeNode curr, int sum, int target, Map<Integer, Integer> map) {
        if (curr == null) {
            return 0;
        }
        // update the prefix sum by adding the current val
        sum += curr.val;
        // get the number of valid path, ended by the current node
        int numPathToCurr = map.getOrDefault(sum-target, 0);
        // update the map with the current sum, so the map is good to be passed to the next recursion
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        // add the 3 parts discussed in 8. together
        int res = numPathToCurr + findPathSum(curr.left, sum, target, map)
                + findPathSum(curr.right, sum, target, map);
        // restore the map, as the recursion goes from the bottom to the top
        map.put(sum, map.get(sum) - 1);
        return res;
    }

    /*sum - target 理解成以当前点作为终点能得到target的路线的条数, 是 prefix - target 前那一段的条数*/
}
