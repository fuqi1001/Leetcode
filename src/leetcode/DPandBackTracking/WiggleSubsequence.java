package leetcode.DPandBackTracking;

import java.util.Arrays;

/**
 * Created by qifu on 17/2/6.
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int size = nums.length;
        if(size == 0) return 0;

        int[] up = new int[size];
        int[] down = new int[size];

        Arrays.fill(up,1);
        Arrays.fill(down,1);

        for(int i = 1; i < size; i++){
            for(int j = 0 ; j < i; j++){
                if(nums[j] < nums[i]){   //going down
                    up[i] = Math.max(up[i], down[j] + 1);
                } else {            //goind up
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
        }

        Arrays.sort(up);
        Arrays.sort(down);
        return Math.max(up[size - 1], down[size - 1]);

    }



    ///
    public int wiggleMaxLength(int[] nums) {
        int size = nums.length;
        if(size == 0) return 0;

        int res = 1;

        for(int i = 1, j = 0; i < size; j = i, i++){
            if(nums[j] < nums[i]) {     //going up
                res++;
                while(i + 1 < size && nums[i] <= nums[i + 1]) i++;      //keep going up ? jump
            }
            else if(nums[j] > nums[i]) {        //going down
                res++;
                while(i + 1 < size && nums[i] >= nums[i + 1]) i++;      //keep going down ? jump
            }
        }
        return res;
    }
}