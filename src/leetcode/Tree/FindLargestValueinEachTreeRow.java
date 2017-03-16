package leetcode.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qifu on 17/2/13.
 */
public class FindLargestValueinEachTreeRow {
    public int[] largestValues(TreeNode root) {
        if(root==null) return new int[0];
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int max = q.peek().val;
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode cur = q.poll();
                max = Math.max(max, cur.val);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            res.add(max);
        }
        return res.stream().mapToInt(k->k).toArray();
    }
}
