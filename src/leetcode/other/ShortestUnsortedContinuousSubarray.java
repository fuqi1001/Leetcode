package leetcode.other;

import java.util.Arrays;

/**
 * Created by qifu on 17/5/16.
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int start = -1, end = -1;
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[len-1-i]);
            max = Math.max(max, nums[i]);

            if(nums[i] < max) {
                end = i;
            }
            if(nums[len-1-i] > min) {
                start = len-1-i;
            }
        }
        if(start == -1) return 0;
        return end - start + 1;
    }

    //
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int start = 0, end = nums.length - 1;
        int index = 0;
        while(start < nums.length && nums[start] == temp[start]) start++;
        while(end >= start && nums[end] == temp[end]) end--;
        return end - start + 1;
    }
}
