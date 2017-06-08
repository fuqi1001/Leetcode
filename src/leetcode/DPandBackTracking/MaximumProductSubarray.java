package leetcode.DPandBackTracking;

/**
 * Created by qifu on 17/2/14.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int res = maxProduct;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] >= 0) {
                maxProduct = Math.max(maxProduct * nums[i], nums[i]);
                minProduct = Math.min(minProduct * nums[i], nums[i]);
            } else {
                int temp = maxProduct;
                maxProduct = Math.max(minProduct * nums[i], nums[i]);
                minProduct = Math.min(temp * nums[i], nums[i]);
            }
            res = Math.max(res, maxProduct);
        }
        return res;
    }
}
