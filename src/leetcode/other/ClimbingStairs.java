package leetcode.other;

/**
 * Created by qifu on 16/9/7.
 */
public class ClimbingStairs {
    public int climbStairs(int n ){
        if(n <= 2) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n ;i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n-1];

        /*
        因为只能爬 1 和 2步
        所以当前步数 要么是 上一阶走一步
        要么是 上一阶走两步
        所以 dp[i] = dp[i-1]+dp[i-2];
         */
    }
}
