package leetcode.other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qifu on 17/4/2.
 */
public class FriendCircles {

    //union-find
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for(int i = 0; i < M.length; i++) {
            for(int j = 0; j < M.length; j++) {
                if(M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < parent.length; i++) {
            if(parent[i] == -1) count++;
        }
        return count;
    }
    private void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        if(xSet != ySet) {
            parent[xSet] = ySet;
        }
    }
    private int find(int[] parent, int i) {
        if(parent[i] == -1) return i;
        return find(parent, parent[i]);
    }

    //DFS
    public int findCircleNum(int[][] M) {
        int count = 0;
        int[] visited = new int[M.length];
        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] M, int[] visited, int i) {
        for(int j = 0; j < M.length; j++) {
            if(M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    //BFS
    public int findCircleNum(int[][] M) {
        int count = 0;
        int[] visited = new int[M.length];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < M.length; i++) {
            if(visited[i] == 0) {
                queue.add(i);
                while(!queue.isEmpty()) {
                    int cur = queue.poll();
                    visited[cur] = 1;
                    for(int j = 0; j < M.length; j++) {
                        if(M[cur][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
