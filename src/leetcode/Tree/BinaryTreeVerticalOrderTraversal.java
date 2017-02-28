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


    /// 201 / 212
    int min = 0;
    int max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        setMap(map, root, 0);
        for(int i = min ; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
    public void setMap(Map<Integer, List<Integer>> map, TreeNode root, int num) {
        if(root == null) return;
        min = Math.min(num, min);
        max = Math.max(num, max);
        if(!map.containsKey(num)){
            map.put(num, new ArrayList<>());
            map.get(num).add(root.val);
        } else {
            map.get(num).add(root.val);
        }

        if(root.left != null){
            setMap(map, root.left, num - 1);
        }
        if(root.right != null) {
            setMap(map, root.right, num + 1);
        }
    }
}
