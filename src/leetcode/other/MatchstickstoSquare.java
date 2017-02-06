package leetcode.other;

import java.util.Arrays;

/**
 * Created by qifu on 17/2/6.
 */
public class MatchstickstoSquare {
    public boolean makesquare(int[] nums){
        if(nums == null || nums.length == 0) return false;

        int sum = 0;
        for(int cur : nums){
            sum += cur;
        }
        if(sum % 4 != 0) return false;
        return dfs(nums, new int[4], 0, sum / 4);

    }

    private boolean dfs(int[] nums, int[] edge, int index, int target){
        if(index == nums.length){
            if(edge[0] == target && edge[1] == target && edge[1] == target) {
                return true;
            }
            return false;
        }

        for(int i = 0 ; i < 4; i++){
            if(edge[i] + nums[index] > target) continue;
            edge[i] += nums[index];
            if(dfs(nums, edge, index + 1, target)) return true;
            edge[i] -= nums[index];
        }
        return false;
    }

    ///
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 4 != 0) return false;
        int width = sum / 4;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;
        Arrays.sort(nums);
        return helper(nums, nums.length - 1, sum1, sum2, sum3, sum4, width);
    }

    private boolean helper(int[] nums, int index, int sum1, int sum2, int sum3, int sum4, int width){
        if(sum1 > width || sum2 > width || sum3 > width || sum4 > width) return false;
        if(index == -1){
            if(sum1 == width && sum2 == width && sum3 == width && sum4 == width){
                return true;
            }
            else return false;
        }

        return
                helper(nums, index - 1, sum1 + nums[index], sum2, sum3, sum4, width) ||
                        helper(nums, index - 1, sum1 , sum2+ nums[index] , sum3, sum4, width) ||
                        helper(nums, index - 1, sum1 , sum2, sum3+ nums[index] , sum4, width) ||
                        helper(nums, index - 1, sum1 , sum2, sum3, sum4+ nums[index] , width);

    }
}
