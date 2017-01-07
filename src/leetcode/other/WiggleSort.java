package leetcode.other;

import java.util.Arrays;

/**
 * Created by qifu on 17/1/7.
 */
public class WiggleSort {
    public void wiggleSort(int[] nums){
        int len = nums.length;
        for(int i = 0 ; i < len; i++){
            if(i % 2 == 1){
                if( nums[i - 1] > nums[i])
                    swap(nums, i);
            }
            else if(i != 0 && nums[i - 1] < nums[i]){
                swap(nums, i);
            }
        }
    }

    private void swap(int[] nums, int i){
        int temp = nums[i];
        nums[i ] = nums[i - 1];
        nums[i - 1] = temp;
    }
}
