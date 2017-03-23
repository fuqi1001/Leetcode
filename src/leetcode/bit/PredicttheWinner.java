package leetcode.bit;

/**
 * Created by qifu on 17/3/22.
 */
public class PredicttheWinner {

    //https://discuss.leetcode.com/topic/76830/java-9-lines-dp-solution-easy-to-understand-with-improvement-to-o-n-space-complexity

    //重点在第五句

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];     //用来存player获利（范围内）
        for(int i = 0; i < n ; i++) dp[i][i] = nums[i];
        int len = 1;
        for(;len < n; len++){
            for(int i = 0; i < n - len; i++) {
                int j = i + len;        //范围内的最后一位
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
                    /*
                    重点在于dp[i][j] 表示 A 的最大获利， 在取nums[i] 与  nums[j]之间抉择最大的
                    如果取nums[i], 则A比B 最后多获利 nums[i] - dp[i+1][j] (可能为正可能为负)
                    dp[i+1][j]表示在i+1~j这个范围内 B可能比A多获得的值. 取nums[j]同理
                    所以在这两者之间挑较大的赋给dp[i][j].


                    */
            }
        }
        return dp[0][n-1] >= 0;
    }

    //O(n) space
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        if(n % 2 == 0) return true;
        int[] dp = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(i == j) {
                    dp[i] = nums[i];
                } else {
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                }
            }
        }
        return dp[n - 1] >= 0;
    }

    //
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length - 1) >= 0;
    }
    private int helper(int[] nums, int start, int end) {
        return start == end ? nums[end] : Math.max(nums[end] - helper(nums, start, end - 1), nums[start] - helper(nums, start + 1, end));
    }
}
