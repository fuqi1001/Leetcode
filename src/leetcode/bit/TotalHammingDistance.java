package leetcode.bit;

/**
 * Created by qifu on 17/2/2.
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int total = 0;

        for(int i = 0 ; i < 32; i++){
            int bitCount = 0;

            for(int j = 0; j < nums.length; j++){
                bitCount += (nums[j] >> i) & 1;
            }
            total += bitCount * (nums.length - bitCount);
        }
        return total;

    }
}
