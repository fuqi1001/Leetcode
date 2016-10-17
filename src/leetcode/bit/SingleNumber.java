package leetcode.bit;

/**
 * Created by qifu on 16/10/16.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        int result = 0;
        for(int i = 0 ; i < 32 ; i++){
            for(int j = 0 ; j < nums.length ;j++){
                if( ((nums[j] >> i ) & 1) == 1){
                    count[i]++;
                }
            }
            result |= ((count[i] % 3) << i);
        }
        return result;
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            int sum = 0;
            for(int n: nums)
                if((n >> i & 1) == 1)
                    sum++;
            sum %= 3;
            res |= sum<<i;
        }
        return res;
    }

    public int singleNumber(int[] nums) {
        int p = 0;
        int q = 0;
        int r;
        for(int i = 0; i<nums.length; i++){
            r = nums[i]; //this to make it consistent with our analysis.
            p = q & (p ^ r);
            q = p | (q ^ r);
        }
        return q;
    }
}



//http://www.acmerblog.com/leetcode-single-number-ii-5394.html