package leetcode.DP;

import java.util.HashMap;
import java.util.Map;

public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
/**
 * Created by qifu on 16/10/11.
 */
public class HouseRobber3 {
    //naive
    public int rob(TreeNode root){
        if(root == null) return 0;
        int val = 0;
        if(root.left != null){
            val += rob(root.left.left) + rob(root.left.right);
        }

        if(root.right != null){
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(val + root.val , rob(root.left) + rob(root.right));
    }


    //dp hashmap

    public int rob(TreeNode root) {
        Map<TreeNode,Integer> map = new HashMap<>();
        return robSub(root,map);
    }
    public int robSub(TreeNode root, Map<TreeNode, Integer> map){
        if(root == null) return 0;

        if(map.containsKey(root)) return map.get(root);

        int val = 0;
        if(root.left != null){
            val += robSub(root.left.left,map)+robSub(root.left.right,map);
        }
        if(root.right != null){
            val += robSub(root.right.left,map)+robSub(root.right.right,map);
        }
        val = Math.max(val + root.val, robSub(root.left,map)+robSub(root.right,map));
        map.put(root,val);
        return val;
    }

    //best?

    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0],res[1]);
    }
    public int[] robSub(TreeNode root){
        if(root == null){
            return new int[2];
        }
        int[] left = robSub(root.left);
        int[] right =robSub(root.right);

        int res[] = new int[2];
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0] , right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;

    }
}
