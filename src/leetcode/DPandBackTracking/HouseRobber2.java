package leetcode.DPandBackTracking;

/**
 * Created by qifu on 16/10/11.
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        dp1[0] = 0;
        dp1[1] = nums[0];
        for(int i = 2 ; i < dp1.length ;i++){
            dp1[i] = Math.max(dp1[i - 1] , dp1[i - 2]+ nums[i - 1]);
        }
        dp2[0] = 0;
        dp2[1] = nums[1];
        for(int i = 2 ; i < dp2.length ;i++){
            dp2[i] = Math.max(dp1[i - 1] , dp1[i - 2]+ nums[nums.length - i]);
        }
        return dp1[dp1.length - 1] > dp2[dp2.length - 1] ? dp1[dp1.length - 1]: dp2[dp2.length - 1];
    }
}
