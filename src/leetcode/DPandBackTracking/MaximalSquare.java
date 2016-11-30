package leetcode.DPandBackTracking;

/**
 * Created by qifu on 16/11/20.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max,dp[i][0]);
        }

        for(int i = 0 ; i < n ; i++){
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(max,dp[0][i]);
        }

        for(int i = 1 ; i < m ;i++){
            for(int j = 1 ; j < n ; j++){
                dp[i][j] = matrix[i][j] == '1' ? Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]))+1:0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
