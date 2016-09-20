package leetcode.bit;

/**
 * Created by qifu on 16/9/20.
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int reverse = 0;
        for(int i = 0 ; i < 32 ;i++){
            reverse = (reverse << 1) | (n & 1);
            n = n>>1;
        }
        return reverse;
    }
}
