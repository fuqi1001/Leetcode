package leetcode.other;

/**
 * Created by qifu on 17/3/9.
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max;
    }

    //
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = 0;
        int cur_len = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1) cur_len++;
            len = Math.max(len, cur_len);
            if(nums[i] == 0) {
                cur_len = 0;
            }


        }
        return len;
    }
}
