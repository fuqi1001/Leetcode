package leetcode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qifu on 17/3/4.
 */
public class FindModeinBinarySearchTree {

    //inorder keep check all root val
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] max = new int[1];
        inorder(root, map, max);
        System.out.println(max[0]);
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max[0]) {
                list.add(entry.getKey());
            }
        }
        int size = list.size();
        int[] res = new int[size];
        int index = 0;
        for(int cur : list){
            res[index++] = cur;
        }
        return res;

    }
    public void inorder(TreeNode root, HashMap<Integer, Integer> map, int[] max) {
        if(root == null) return;
        inorder(root.left, map, max);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        max[0] = Math.max(max[0], map.get(root.val));
        inorder(root.right, map, max);
    }


    ///
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int[] track = new int[3];           // track[0] = prev; track[1] = cur_max; track[2] = max;
        inorder(root, track, list);
        int[] res = new int[list.size()];
        int index = 0;
        for(int num : list) {
            res[index++] = num;
        }
        return res;
    }
    private void inorder(TreeNode root, int[] track, List<Integer> list) {
        if(root == null) return;
        inorder(root.left, track, list);

        if(root.val == track[0]) {
            track[1] += 1;
        } else {
            track[1] = 1;
        }

        if(track[1] >= track[2]) {
            if(track[1] > track[2]) {
                list.clear();
            }
            track[2] = track[1];
            if(list.isEmpty() || list.get(list.size() - 1) != root.val) {
                list.add(root.val);
            }
        }
        track[0] = root.val;
        inorder(root.right, track, list);
    }
}
