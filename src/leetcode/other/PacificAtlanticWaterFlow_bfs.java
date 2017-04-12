package leetcode.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qifu on 17/2/6.
 */
public class PacificAtlanticWaterFlow_bfs {
    int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];

        Queue<int[]> queue_p = new LinkedList<>();
        Queue<int[]> queue_a = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            queue_p.add(new int[]{i, 0});
            queue_a.add(new int[]{i, n - 1});
            p[i][0] = true;
            a[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            queue_p.add(new int[]{0, i});
            queue_a.add(new int[]{m - 1, i});
            p[0][i] = true;
            a[m - 1][i] = true;
        }
        bfs(matrix, queue_p, p);
        bfs(matrix, queue_a, a);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] && a[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        int m = matrix.length;
        int n = matrix[0].length;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] cur : dir) {
                int x = node[0] + cur[0];
                int y = node[1] + cur[1];
                if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] < matrix[node[0]][node[1]] || visited[x][y])
                    continue;
                visited[x][y] = true;
                queue.add(new int[]{x, y});
            }
        }
    }
}