package leetcode.DPandBackTracking;

/**
 * Created by qifu on 16/12/31.
 */
public class PaintFence {

    public int numWays(int n, int k){
        int dif = k * (k + 1);
        int same = k;

        if(n == 0) return 0;
        if(n == 1) return k;

        for(int i = 2; i < n ;i++){
            int temp = dif;
            dif = (dif + same) * (k - 1);
            same = temp;
        }

        return dif + same;
    }

    //
    public int numWays(int n, int k) {
        int[] dp = {0, k, k*k, 0};
        if(n <= 2) return dp[n];
        for(int i = 3; i <= n; i++){
            dp[3] = (k-1) *(dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }
}
