package leetcode.DPandBackTracking;

public class LongestIncreasingPathinaMatrix {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int res = 1, n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int len = dp[i][j];
                if(dp[i][j] == 0) {
                    len = helper(matrix, i, j, n, m, dp);
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }

    public int helper(int[][] matrix, int i, int j, int n, int m, int[][] dp) {
        if(dp[i][j] != 0) return dp[i][j];
        int max = 1;
        for(int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= n || y < 0 || y >= m || matrix[x][y] <= matrix[i][j])  continue;
            int len = 1 + helper(matrix, x, y, n, m, dp);
            max = Math.max(max, len);
        }
        dp[i][j] = max;
        return max;
    }

}
