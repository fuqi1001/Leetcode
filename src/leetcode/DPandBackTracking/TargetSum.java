package leetcode.DPandBackTracking;

/**
 * Created by qifu on 17/3/23.
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return sum < S || (S + sum) % 2 != 0 ? 0 : helper(nums, (sum + S) >>> 1);
    }
    public int helper(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for(int n : nums) {
            for(int i = s; i >= n; i--){
                dp[i] += dp[i - n];
            }
        }
        return dp[s];
    }
}

/*
    原理:
    数组划分为正数负数两部分
    sum[正] + sum[负] = target;
    =>  sum[正] + sum[负] + sum[正] - sum[负] = target + sum[正] + sum[负];
    =>  2 * sum[正] = target + SUM;
    =>  sum[正] = (target + SUM) / 2;

     DP原理:  dp数组储存求和种类
     因为   i = i - n + n;
     所以   能构成i 的组合 为 累加上能构成 i - n 的种类;
     dp[i] += dp[i - n];
 */
