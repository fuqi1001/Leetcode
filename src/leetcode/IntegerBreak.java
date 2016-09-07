package leetcode;

/**
 * Created by qifu on 16/9/6.
 */
public class IntegerBreak {
    //math
    public int integerBreak(int n){
        if(n == 2 || n == 3) return n-1;
        int result = 1;
        while( n > 4){
            result *= 3;
            n -= 3;
        }
        return result * n;
    }

    //dp
    public int integerBreak(int n){
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 1;
        else if(n == 3) return 2;
        else if(n == 4) return 4;
        else{
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 2;
            dp[4] = 4;
            for(int i = 5; i <= n ; i++){
                dp[i] = 3 * Math.max(i-3, dp[i-3]);
            }
            return dp[n];

        }
    }
    /*
    2 => 1, 1 => 1
3 => 2, 1 => 2
4 => 2, 2 => 4
5 => 3, 2 => 6
6 => 3, 3 => 9
7 => 3, 4 => 12
8 => 3, 5 => 18
9 => 3, 6 => 27
10 => 3, 7 => 36

By observation, when you get maximum, one of the num is always 3.
After 3, the result will be larger than or equal the number itself.
     */
}
