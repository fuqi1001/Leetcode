package leetcode.DPandBackTracking;

/**
 * Created by qifu on 16/10/18.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < nums.length;i++){
            sum += nums[i];
            res = Math.max(res,sum);
            sum = Math.max(sum,0);
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        int res = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        for(int i = 0 ; i < nums.length ;i++){
            sum += nums[i];
            res  = Math.max(res, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return res;
    }

    public int maxSubArray(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        int max = dp[0];
        for(int i = 1; i < len ;i++){
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            max = max > dp[i] ? max: dp[i];
        }
        return max;
    }


}
