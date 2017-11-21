package z_leetcode.bloomberg_onsite;

public class ClimbingStairs {
    public int climb1(int n) {
        if(n <= 2) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //follow up
    public int climb2(int n, int m) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= n; i++) {
            res[i] = 0;
            for(int j = 1; j <= m && j < i; j++) {
                res[i] += res[i - j];
            }
        }
        return res[n];
    }

    public int countWays(int s, int m) {
        return climb2(s+1, m);
    }
}
