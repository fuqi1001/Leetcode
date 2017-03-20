package leetcode.other;

/**
 * Created by qifu on 17/3/20.
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int dif = 0;
        for(int num : nums) {
            dif ^= num;
        }

        dif &= -dif;        //找到最右边的第一个1,可以用这个把数组分成两组
        int[] res = new int[2];
        for(int num : nums) {
            if( (dif & num) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
