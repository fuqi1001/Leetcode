package leetcode.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qifu on 16/11/15.
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 1) {
            res.add(0);
            return res;
        }
        List<HashSet<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < graph.size(); i++) {
            if(graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves) {
                int neighbor = graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);
                if(graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
    /*
    将整个树存在图中, 每次找只有一个相连节点的treeNode
    这肯定是个叶子节点,从结果中剔除
    并且将他们从相连节点的邻居节点中剔除
    进行下一轮循环,直到剩下2个点或者2个以下

     */
}
