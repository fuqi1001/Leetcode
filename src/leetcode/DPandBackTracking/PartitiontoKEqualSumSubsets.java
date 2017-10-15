package leetcode.DPandBackTracking;

public class PartitiontoKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length, target = 0;
        for(int num : nums) target += num;
        if(target % k == 0) target /= k;
        else return false;
        return help(nums, target, 0, k, target);
    }

    public boolean help(int[] nums, int target, int start, int k, int sum) {
        if(k == 1) return true;
        if(sum == 0) return help(nums, target, 0, k - 1, target);
        for(int i = start; i < nums.length; i++) {
            if(help(nums, target, i+1, k, sum - nums[i])) return true;
        }
        return false;
    }
}
