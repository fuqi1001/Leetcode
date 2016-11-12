package leetcode;

/**
 * Created by qifu on 16/11/11.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int left =0, right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while(right < len){
            if(sum < s){
                sum += nums[right];
                right++;
            }else{
                minLen =  Math.min(minLen, right - left);
                if(left == right - 1) return 1;
                sum -= nums[left];
                left++;
            }
        }

        while(sum >= s){
            minLen = Math.min(minLen, right - left);
            sum -= nums[left];
            left++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
