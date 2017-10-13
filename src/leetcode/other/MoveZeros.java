package leetcode.other;

/**
 * Created by qifu on 16/8/18.
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)return;
        int index = 0;
        for(int num : nums) {
            if(num != 0) nums[index++] = num;
        }
        while(index < nums.length) {
            nums[index++] = 0;
        }
    }


    //暴力
    public void moveZeroes(int[] nums) {
        int start = 0;
        int find = start;
        while(start < nums.length){
            if(nums[start] == 0){
                while(find < nums.length - 1 &&nums[find] == 0 ) find++;
                if(nums[find] != 0){
                    int temp = nums[find];
                    nums[find] = nums[start];
                    nums[start] = temp;
                }
            }
            if(nums[start] == 0 && find >= nums.length - 1) break;
            start++;
            find = start;

        }
    }
}
