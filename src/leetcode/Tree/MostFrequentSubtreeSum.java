package leetcode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qifu on 17/2/4.
 */
public class MostFrequentSubtreeSum {
    //
    private int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        if(root.left == null && root.right == null){
            int[] res = new int[1];
            res[0] = root.val;
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int temp = Sum(root, map);
        List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //System.out.println(entry.getValue());
            if(entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }

        int[] res = new int[list.size()];
        int index = 0;
        for(int num : list) {
            res[index++] = num;
        }
        return res;
    }

    public int Sum(TreeNode root, Map<Integer, Integer> map) {
        // System.out.println("run");
        if(root == null) return 0;
        if(root.left == null  && root.right == null ){
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            max = Math.max(max, map.get(root.val));
            return root.val;
        }

        int left = Sum(root.left, map);
        int right = Sum(root.right, map);

        int cur = root.val + left + right;

        map.put(cur, map.getOrDefault(cur, 0) + 1);
        max = Math.max(max, map.get(cur));
        //System.out.println("max" +max);
        return cur;
    }
}
