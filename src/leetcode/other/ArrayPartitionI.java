package leetcode.other;

import java.util.Arrays;

/**
 * Created by qifu on 17/5/16.
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length; i+=2) {
            res += nums[i];
        }
        return res;
    }

    /*
    数学题

    默认  b >= a in each pair
    Sm = min(a1,b1) +...+min(an,bn);
    Sa = a1+b1+...+an+bn;
    Sd = |b1 - a1|
    Sa = a1 + a1 + d1 + a2 + a2 + d2 + ... + an + an + di
       = 2Sm + Sd => Sm = (Sa - Sd) / 2

       Sa is constant, we need to make Sd as small as possible.

     */
}
