package leetcode.other;

/**
 * Created by qifu on 17/3/20.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for(int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    //
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[m];
        res[0] = grid[0][0];
        for(int i = 1; i < m; i++) {
            res[i] = res[i-1] + grid[i][0];
        }
        for(int j = 1; j < n; j++) {
            res[0] += grid[0][j];
            for(int i = 1; i < m; i++) {
                res[i] = Math.min(res[i-1], res[i]) + grid[i][j];
            }
        }
        return res[m-1];
    }
}
