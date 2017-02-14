package leetcode.DPandBackTracking;

/**
 * Created by qifu on 17/2/14.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int maxP = nums[0];
        int minP = nums[0];

        int res = maxP;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] >= 0){
                maxP = Math.max(maxP * nums[i], nums[i]);
                minP = Math.min(minP * nums[i], nums[i]);
            } else {
                int temp = maxP;
                maxP = Math.max(minP * nums[i], nums[i]);
                minP = Math.min(temp * nums[i], nums[i]);
            }
            res = Math.max(res, maxP);
        }
        return res;
    }
}
