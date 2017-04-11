package leetcode.DPandBackTracking;

/**
 * Created by qifu on 16/10/11.
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    public int helper(int[] nums, int left, int right) {
        int in = 0, out = 0;
        for(int i = left; i <= right; i++) {
            int temp_in = in;           //in表示nums[cur],out表示不包括nums[cur]
            int temp_out = out;         //上一轮的结果
            in = temp_out + nums[i];    //temp_out不包括上一轮边界,所以可以加nums[cur];
            out = Math.max(temp_in, temp_out);
        }
        return Math.max(in, out);
    }
    /*
    统计 0 -> (len - 1)
    或者 1 -> (len)
    就两种情况

    无需dp储存中间
     */
}
