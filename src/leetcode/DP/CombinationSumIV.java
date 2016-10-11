package leetcode.DP;

import java.util.Arrays;

/**
 * Created by qifu on 16/10/11.
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target ; i++){
            for(int num: nums){
                if(i >= num){
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }


    public int combinationSum4(int[] nums, int target){
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for(int i = 1; i <= target ; i++){
            for(int num : nums){
                if(i < num) break;
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
