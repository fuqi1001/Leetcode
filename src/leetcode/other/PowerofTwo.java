package leetcode.other;

/**
 * Created by qifu on 17/3/13.
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return  (n & (n - 1) ) == 0;
    }
    //
    public boolean isPowerOfTwo(int n) {
        if(n > 1) {
            while(n % 2 == 0) {
                n /= 2;
            }
        }
        return n == 1;
    }
}
