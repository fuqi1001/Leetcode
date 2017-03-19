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


    ///dp way, but wrong
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix.size() == 0) return res;
        int m = matrix.size();
        int n = matrix.get(0).size();
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(matrix.get(i).get(j) == 1) {
                    if(check(matrix, i ,j)) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] == Integer.MAX_VALUE) {
                    dp[i][j] = plus(dp, i,j);
                }
            }
        }
        for(int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < n; j++){
                list.add(dp[i][j]);
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    public boolean check(List<List<Integer>> matrix, int i ,int j) {
        boolean flag = false;
        if(i + 1 < matrix.size() && matrix.get(i + 1).get(j) == 0) flag = true;
        else if(i - 1 >= 0 && matrix.get(i - 1).get(j) == 0) flag = true;
        else if(j + 1 < matrix.get(0).size() && matrix.get(i).get(j + 1) == 0) flag = true;
        else if(j - 1 >= 0 && matrix.get(i).get(j - 1) == 0) flag = true;

        return flag;
    }
    public int plus(int[][] dp, int i , int j) {
        int up = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(i - 1 >= 0 && dp[i-1][j] != Integer.MAX_VALUE) {
            up = dp[i-1][j] + 1;
        }
        if(j - 1 >= 0 && dp[i][j - 1] != Integer.MAX_VALUE) {
            left = dp[i][j-1] + 1;
        }
        if(i + 1 < dp.length && dp[i+1][j] != Integer.MAX_VALUE) {
            down = dp[i+1][j] + 1;
        }
        if(j + 1 < dp[0].length && dp[i][j+1] != Integer.MAX_VALUE) {
            right = dp[i][j+1] + 1;
        }
        if(i == 0 && j == 8) {
            System.out.println(up+" "+down+" "+left +" "+right);
        }
        return Math.min(Math.min(up, down), Math.min(right , left));
    }

}
