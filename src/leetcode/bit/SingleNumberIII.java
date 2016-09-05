package leetcode.bit;

/**
 * Created by qifu on 16/9/5.
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums){
        int diff = 0;
        for(int num : nums){
            diff ^= num;
        }

        diff &= -diff;

        int[] result = {0,0};
        for(int num : nums){
            if((num & diff) == 0){
                result[0] ^= num;
            }
            else{
                result[1] ^= num;
            }
        }
        return result;
    }
    //http://www.cnblogs.com/grandyang/p/4741122.html

    //https://discuss.leetcode.com/topic/56318/examples-to-explain-the-xor-solution-and-bit-manipulation-trick
}
