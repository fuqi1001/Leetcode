package leetcode.DPandBackTracking;

import java.util.Arrays;

/**
 * Created by qifu on 16/11/20.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 1 ; i <= amount ; i++){
            dp[i] = 0x7fffffff;
            for(int j = 0 ; j < coins.length; j++){
                if(i >= coins[j] && dp[i - coins[j] ]!= 0x7fffffff){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == 0x7fffffff? -1 : dp[amount];
    }


    //
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            dp[i] = 0x7fff_fffe;
        }
        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == 0x7fff_fffe ? -1 : dp[amount];
    }
}

