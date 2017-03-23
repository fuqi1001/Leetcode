package leetcode.DPandBackTracking;

/**
 * Created by qifu on 16/10/18.
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if((sum & 1) == 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int num : nums) {
            for(int i = sum; i > 0 ; i--) {
                if(i >= num)
                    dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }

}
/*


    part 1:
    分成两组相同, 说明总和可以被2除尽


    part 2:
    01背包
    dp 用来存是否存在和为i 的组合
    dp[0] = true;

    因为 i = i - n + n;
    所以 dp[i] 是否为true 可又  i - n 推出 ( i - n + n )
    dp[i] = dp[i] || dp[i - n]

    最后返回dp[sum]
 */