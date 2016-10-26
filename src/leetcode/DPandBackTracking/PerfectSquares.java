package leetcode.DPandBackTracking;

import java.util.Arrays;

/**
 * Created by qifu on 16/10/25.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i = 1; i * i <= n;i++){
            dp[i * i] = 1;
        }
        for(int i = 1; i<= n ;i++){
            for(int j = 1; i+j*j <= n ;j++){
                dp[i+j*j] = Math.min(dp[i] + 1,dp[i+j*j]);
            }
        }
        return dp[n];
    }
    //math
    public int numSquares(int n) {
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        for (int a=0; a*a<=n; ++a) {
            int b = (int) Math.sqrt(n - a*a);
            if (a*a + b*b == n)
                return a == 0 ? 1 : 2;
        }
        return 3;
    }
}
