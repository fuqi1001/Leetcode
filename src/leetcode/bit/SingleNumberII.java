package leetcode.bit;

/**
 * Created by qifu on 17/3/30.
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int[] bit = new int[32];
        int result = 0;
        for(int i = 0; i < 32; i++) {
            for(int j = 0; j < nums.length; j++) {
                bit[i] += (nums[j] >> i) & 1;
                bit[i] %= 3;
            }
            result |= (bit[i] << i);
        }
        return result;
    }
}
