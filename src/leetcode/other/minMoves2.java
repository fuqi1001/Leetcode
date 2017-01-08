package leetcode.other;

import java.util.Arrays;

/**
 * Created by qifu on 17/1/8.
 */
public class minMoves2 {
    public int minMoves2(int[] nums){
        int[] res = new int[nums.length];

        for(int i = 0 ; i < nums.length; i++){
            res[i] = 0;
            for(int j = 0; j < nums.length; j++){
                res[i] += Math.abs(nums[i] - nums[j]);
                if(res[i] < 0){
                    res[i] = Integer.MAX_VALUE;
                    break;
                }
            }

        }
        Arrays.sort(res);
        return res[0];
    }

///
    public int minMoves2(int[] nums){
        Arrays.sort(nums);
        int i = 0 , j = nums.length - 1;
        int count = 0;
        while(i < j){
            count += nums[j] - nums[i];
            i++;j--;
        }
        return count;
    }
}
