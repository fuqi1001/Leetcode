package leetcode.Tree;

import java.util.*;

/**
 * Created by qifu on 17/2/4.
 */
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> tree = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        tree.add(root);
        cols.add(0);

        int min = 0;
        int max = 0;

        while(!tree.isEmpty()){
            TreeNode cur = tree.poll();
            int col = cols.poll();

            if(!map.containsKey(col)){
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(cur.val);


            if(cur.left != null){
                tree.add(cur.left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }

            if(cur.right != null){
                tree.add(cur.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }

        }
        for(int i = min; i <= max; i++){
            res.add(map.get(i));
        }
        return res;
    }
}
