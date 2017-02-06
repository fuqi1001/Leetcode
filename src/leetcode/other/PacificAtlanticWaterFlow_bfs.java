package leetcode.other;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qifu on 17/2/6.
 */
public class PacificAtlanticWaterFlow_bfs {

    int[][] dir = new int[][] {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] p = new boolean[n][m];
        boolean[][] a = new boolean[n][m];

        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m - 1});
            p[i][0] = true;
            a[i][m - 1] = true;
        }

        for(int i = 0; i < m; i++){
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{n-1, i});
            p[0][i] = true;
            a[n-1][i] = true;
        }

        bfs(matrix, pQueue,p);
        bfs(matrix, aQueue,a);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(p[i][j] && a[i][j]) {
                    res.add(new int[] {i,j});
                }
            }
        }
        return res;
    }

    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited){
        int n = matrix.length;
        int m = matrix[0].length;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] d : dir){
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if(x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) {
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[] {x,y});
            }
        }
    }
}
