package leetcode.z_amazon;

import java.util.*;

public class GriticalNode {

    /**
     * Use Dfs,
     * A node a is parent of another Node b, if b is discovered by u
     * In DFS tree, a node a is articulation node:
     * 1. a is root of DFS tree, and it has at lease two children
     * 2. a is not root of DFS tree, and it has a child b such that
     * no node in subtree rooted with b has a back edge to on of the ancestors of a.
     * In DFS traversal, we maintain a parent[] array where parent[a] stores parent of node a,
     * among the above mentioned two cases, the first case is simple to detect.
     * for every node, count children. if current visited vertex a is root , parent(a) == -1
     * and has two children, append it to result.
     * For case 2, we maintain an array ids[] to store discovery time of node,
     * for every node a, we need to find out the earlist visited node (the node with minimum discovery time)
     * that can be reached from subtree rooted with u. so we maintain array low[]
     * low[u] = min(disc[u], disc[w])
     * where w is an ancestor of u and there is a back edge from
     * some descendant of u to w.
     */


    static int time = 0;

    public static void main(String[] args) {
        int numRouters1 = 7;
        int numLinks1 = 7;
        int[][] links1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
        System.out.println(getCriticalNodes(links1, numLinks1, numRouters1));
    }

    private static List<Integer> getCriticalNodes(int[][] links, int numLinks, int numRouters) {
        time = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < numRouters; i++) {
            map.put(i, new HashSet<>());
        }

        for(int[] link : links) {
            map.get(link[0]).add(link[1]);
            map.get(link[1]).add(link[0]);
        }

        Set<Integer> set = new HashSet<>();
        int[] low = new int[numRouters];
        int[] ids = new int[numRouters];
        int[] parent = new int[numRouters];

        Arrays.fill(ids, -1);
        Arrays.fill(parent, -1);
        for(int i = 0; i < numRouters; i++) {
            if (ids[i] == -1) {
                dfs(map, low, ids, parent, i, set);
            }
        }
        return new ArrayList<>(set);
    }

    private static void dfs(Map<Integer, Set<Integer>> map, int[] low, int[] ids, int[] parent, int cur, Set<Integer> res) {
        int children = 0;
        ids[cur] = low[cur] = ++time;
        for(int nei : map.get(cur)) {
            if (ids[nei] == -1) {
                children++;
                parent[nei] = cur;
                dfs(map, low, ids, parent, nei, res);
                low[cur] = Math.min(low[cur], low[nei]);
                if ((parent[cur] == -1 && children > 1) || (parent[cur] != -1 && low[nei] >= ids[cur]))
                    res.add(cur);
            } else if (nei != parent[cur]) {
                low[cur] = Math.min(low[cur], ids[nei]);
            }
        }
    }

}
