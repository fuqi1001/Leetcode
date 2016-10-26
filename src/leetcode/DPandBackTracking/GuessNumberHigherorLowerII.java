package leetcode.DPandBackTracking;

/**
 * Created by qifu on 16/10/26.
 */
public class GuessNumberHigherorLowerII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return solve(dp,1,n);
    }
    private int solve(int[][] dp, int start, int end){
        if(start >= end) return 0;
        if(dp[start][end] != 0) return dp[start][end];
        dp[start][end] = 0x7FFFFFFF;
        for(int i = start ; i <= end ; i++){
            dp[start][end] = Math.min(dp[start][end], i + Math.max(solve(dp,start,i-1),solve(dp,i+1,end)));
        }
        return dp[start][end];

    }


    //

    public int getMoneyAmount(int n ){
        int[][] dp = new int[n+1][n+1];
        for(int L = n - 1; L > 0 ; L--){
            for(int R = L + 1; R <= n ;R++){
                dp[L][R] = 0x7FFFFFFF;
                for(int i = L; i <R ;i++){
                    dp[L][R] = Math.min(dp[L][R], i + Math.max(dp[L][i - 1],dp[i+1][R]));
                }
            }
        }
        return dp[1][n];
    }
}
