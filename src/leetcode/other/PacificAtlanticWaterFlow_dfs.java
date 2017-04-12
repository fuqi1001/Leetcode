package leetcode.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qifu on 17/2/6.
 */
public class PacificAtlanticWaterFlow_dfs {
    int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null) return res;

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            dfs(matrix, p, Integer.MIN_VALUE, i, 0);
            dfs(matrix, a, Integer.MIN_VALUE, i, n - 1);
        }
        for(int i = 0; i < n; i++) {
            dfs(matrix, p, Integer.MIN_VALUE, 0, i);
            dfs(matrix, a, Integer.MIN_VALUE, m - 1, i);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(p[i][j] && a[i][j]) {
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;
    }
    private void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[x][y] < height) return;

        visited[x][y] = true;

        for(int[] cur : dir) {
            dfs(matrix, visited, matrix[x][y], x + cur[0], y + cur[1]);
        }
    }
}
