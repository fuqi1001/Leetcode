package z_leetcode.bloomberg_onsite;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public int index = 0;
    public TreeMap<Integer, List<Pair>> treeMap;
    public class Pair {
        TreeNode node;
        int index;
        int level;
        public Pair(TreeNode n, int i, int level) {
            this.node = n;
            index = i;
            this.level = level;
        }
    }

    public boolean verticalOrder(TreeNode root) {
        List<List<Pair>> res = new ArrayList<>();
        treeMap = new TreeMap<>();
        if(root == null) return false;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            if(!treeMap.containsKey(cur.index)) {
                treeMap.put(cur.index, new ArrayList<Pair>());
            }
            treeMap.get(cur.index).add(cur);
            if(cur.node.left != null) q.offer(new Pair(cur.node.left, cur.index - 1, cur.level + 1));
            if(cur.node.right != null) q.offer(new Pair(cur.node.right, cur.index + 1, cur.level + 1));
        }

        for(int key : treeMap.keySet()) res.add(treeMap.get(key));

        for(List<Pair> cur : res) {
            for(int i = 0; i < cur.size() - 1; i++) {
                if(cur.get(i).level == cur.get(i+1).level) {
                    return true;
                }
            }
        }
        return false;
    }
}
