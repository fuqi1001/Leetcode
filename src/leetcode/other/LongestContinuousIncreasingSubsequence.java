package leetcode.other;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int max = 1;
        int count = 1;
        int prev = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > prev) count++;
            else {
                max = Math.max(max, count);
                count = 1;
            }
            prev = nums[i];
        }
        max = Math.max(max, count);
        return max;
    }
}
