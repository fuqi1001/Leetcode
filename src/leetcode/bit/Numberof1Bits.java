package leetcode.bit;

/**
 * Created by qifu on 16/8/30.
 */
public class Numberof1Bits {
    public int hammingWeight(int n){
        int count = 0;
        while(n != 0){
            count += n&1;
            n >>>= 1;
        }
        return count;
    }
}