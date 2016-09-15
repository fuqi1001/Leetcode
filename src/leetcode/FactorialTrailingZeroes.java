package leetcode;

/**
 * Created by qifu on 16/9/15.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n){
        if(n < 0) return -1;
        int count = 0;
        for(long i = 5; n / i >= 1; i*=5){
            count+=n/i;
        }
        return count;
    }
}
