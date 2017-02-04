package leetcode.Tree;

import java.util.HashMap;

/**
 * Created by qifu on 17/2/4.
 */
public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        helper(root, map);

        System.out.println(map.keySet());

        int[] res = new int[1];
        return res;
    }

    public int helper(TreeNode root, HashMap<Integer,Integer> map){
        int res = root.val;
        if(root.left != null){
            res += helper(root.left, map);
        }
        if(root.right != null){
            res += helper(root.right, map);
        }

        if(map.containsKey(res)){
            map.put(res,map.get(res) + 1);
        } else {
            map.put(res, 1);
        }

        return res;
    }
}
