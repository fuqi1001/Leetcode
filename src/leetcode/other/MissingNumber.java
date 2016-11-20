package leetcode.other;

import java.util.Arrays;

/**
 * Created by qifu on 16/9/30.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 1){
            if(nums[0] == 0) return 1;
            else    return 0;
        }

        int len = nums[nums.length - 1];
        for(int i = 0; i < len  ;i++){
            if(nums[i] != i){
                return i;
            }
        }
        return len+1;
    }


    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0 ; i < nums.length; i++){
            sum += nums[i];
        }
        int n = nums.length;
        return (int)(0.5*n*(n+1) - sum);
    }
}
