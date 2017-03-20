package leetcode.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qifu on 17/3/18.
 */
public class Matrix01 {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int m = matrix.size();
        if (m == 0) return matrix;
        int n = matrix.get(0).size();
        if (n == 0) return matrix;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix.get(i).set(j, Integer.MAX_VALUE);
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n ||
                        matrix.get(r).get(c) <= matrix.get(cell[0]).get(cell[1]) + 1) continue;
                queue.add(new int[] {r, c});
                matrix.get(r).set(c, matrix.get(cell[0]).get(cell[1]) + 1);
            }
        }

        return matrix;
    }


    ///dp way
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        int[][] dp = new int[m][n];
        for(int[] cur : dp) {
            Arrays.fill(cur, Integer.MAX_VALUE);
        }
        for(int i =  0; i < m;  i++) {
            for(int j = 0;  j < n; j++) {
                if(matrix.get(i).get(j) == 0) dp[i][j] = 0;
                else if(dp[i][j] != 0) {
                    if(i > 0 && dp[i-1][j] != Integer.MAX_VALUE && dp[i][j] > dp[i-1][j] + 1)
                        dp[i][j] = dp[i-1][j] + 1;
                    if(j > 0 && dp[i][j-1] != Integer.MAX_VALUE && dp[i][j] > dp[i][j-1] + 1)
                        dp[i][j] = dp[i][j-1] + 1;
                    if(i < m - 1 && dp[i+1][j] != Integer.MAX_VALUE && dp[i][j] > dp[i+1][j] + 1)
                        dp[i][j] = dp[i+1][j] + 1;
                    if(j < n - 1 && dp[i][j+1] != Integer.MAX_VALUE && dp[i][j] > dp[i][j+1] + 1)
                        dp[i][j] = dp[i][j+1] + 1;
                }
            }
        }

        for(int i = m - 1; i >= 0 ;  i-- ) {
            for(int j = n - 1 ;  j >= 0 ;  j-- ) {
                if(matrix.get(i).get(j) == 0) dp[i][j] = 0;
                else if(dp[i][j] != 0) {
                    if(i > 0 && dp[i-1][j] != Integer.MAX_VALUE && dp[i][j] > dp[i-1][j] + 1)
                        dp[i][j] = dp[i-1][j] + 1;
                    if(j > 0 && dp[i][j-1] != Integer.MAX_VALUE && dp[i][j] > dp[i][j-1] + 1)
                        dp[i][j] = dp[i][j-1] + 1;
                    if(i < m - 1 && dp[i+1][j] != Integer.MAX_VALUE && dp[i][j] > dp[i+1][j] + 1)
                        dp[i][j] = dp[i+1][j] + 1;
                    if(j < n - 1 && dp[i][j+1] != Integer.MAX_VALUE && dp[i][j] > dp[i][j+1] + 1)
                        dp[i][j] = dp[i][j+1] + 1;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int[] row : dp) {
            List<Integer> list = new ArrayList<>();
            for(int num : row) {
                list.add(num);
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }

}
