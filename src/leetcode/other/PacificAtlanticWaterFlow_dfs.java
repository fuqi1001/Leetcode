package leetcode.other;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qifu on 17/2/6.
 */
public class PacificAtlanticWaterFlow_dfs {

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

        for(int i = 0 ; i < n ; i++){
            dfs(matrix,p,Integer.MIN_VALUE,i,0);
            dfs(matrix,a,Integer.MIN_VALUE,i,m-1);
        }

        for(int i = 0; i < m; i++){
            dfs(matrix,p,Integer.MIN_VALUE,0,i);
            dfs(matrix,a,Integer.MIN_VALUE,n-1,i);
        }

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(p[i][j] && a[i][j]) {
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y){
        int n = matrix.length;
        int m = matrix[0].length;

        if(x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height){
            return;
        }

        visited[x][y] = true;

        for(int[] d: dir){
            dfs(matrix, visited, matrix[x][y], x + d[0], y + d[1]);
        }
    }
}
