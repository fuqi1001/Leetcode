package leetcode.DPandBackTracking;

import java.util.Arrays;

/**
 * Created by qifu on 17/2/6.
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] up = new int[len];
        int[] down = new int[len];

        Arrays.fill(up,1);
        Arrays.fill(down,1);

        for(int i = 1; i < len; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    up[i] = Math.max(up[i], down[j] + 1);
                } else if(nums[j] > nums[i]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
        }
        Arrays.sort(up);
        Arrays.sort(down);
        return Math.max(up[len - 1], down[len - 1]);

    }
    ///greedy
    public int wiggleMaxLength(int[] nums) {
        int p = 1, q = 1, n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) p = q + 1;
            else if (nums[i] < nums[i - 1]) q = p + 1;
        }
        return Math.min(n, Math.max(p,q));
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
