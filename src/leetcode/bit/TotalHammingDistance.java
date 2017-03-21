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
                bitCount += (nums[j] >> i) & 1;     //统计所有第i位上为1的数的个数
            }
            total += bitCount * (nums.length - bitCount);   //为1 * 不为1 = 所有hanmming距离
        }
        return total;

    }
}
