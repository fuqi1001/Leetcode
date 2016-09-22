package leetcode;

/**
 * Created by qifu on 16/9/22.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        helper(nums,0,nums.length-1);
        helper(nums,0,k-1);
        helper(nums,k,nums.length-1);

    }

    public void helper(int[] nums, int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
