package leetcode.Implement;

import java.util.Random;

/**
 * Created by qifu on 17/3/27.
 */
public class RandomPickIndex {
    Random random;
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != target) continue;
            count++;
            if(random.nextInt(count) == 0) result = i;
        }
        return result;

    }
}
