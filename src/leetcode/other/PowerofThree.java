package leetcode.other;

/**
 * Created by qifu on 17/3/13.
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        if(n > 1) {
            while(n % 3 == 0) n /= 3;
        }
        return n == 1;
    }
    //
    public boolean isPowerOfThree(int n) {
        return ( n>0 &&  1162261467%n==0);
    }
}
