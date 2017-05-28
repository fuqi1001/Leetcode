package leetcode.DPandBackTracking;

/**
 * Created by qifu on 17/5/27.
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int res = 0;
        boolean[] counted = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(counted[i]) continue;
            int length = 1, val = nums[i];
            while(val != i) {
                length++;
                val = nums[val];
                counted[val] = true;
            }
            res = Math.max(res, length);
        }
        return res;
    }
}
