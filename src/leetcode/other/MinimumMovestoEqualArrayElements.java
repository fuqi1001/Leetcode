package leetcode.other;

/**
 * Created by qifu on 16/12/1.
 */
public class MinimumMovestoEqualArrayElements {
    public int minMoves(int[] nums) {
        if(nums.length == 0) return 0;
        int min = nums[0];
        for(int num : nums){
            min = Math.min(num,min);
        }
        int sum = 0;
        for(int num : nums){
            sum += num - min;
        }
        return sum;
    }
}
