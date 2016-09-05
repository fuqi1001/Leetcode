package leetcode;

import java.util.Arrays;

/**
 * Created by qifu on 16/9/5.
 */
public class singleNumber {
    //O(n ^ 2)
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1 ; i < nums.length - 1; i = i+2){
            if(nums[i] != nums[i-1]) return nums[i-1];
        }
        return nums[nums.length - 1];
    }

    //O(n)  bits
    public int singleNumber(int[] nums) {
        int result = 0 ;
        for(int i = 0 ; i < nums.length ;i++){
            result ^= nums[i];
        }
        return result;
    }
}
