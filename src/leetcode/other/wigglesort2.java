package leetcode.other;

import java.util.Arrays;

/**
 * Created by qifu on 17/2/13.
 */
public class wigglesort2 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int mid = (nums.length + 1) >> 1;
        int[] temp = new int[nums.length];

        int s = mid ;
        int t = nums.length;
        for(int i = 0 ; i < nums.length; i++){
            temp[i] = (i & 1) == 0 ? nums[--s] : nums[--t];
        }
        for(int i = 0 ; i < nums.length; i++){
            nums[i] = temp[i];
        }
    }
}
