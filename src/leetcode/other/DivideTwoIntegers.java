package leetcode.other;

/**
 * Created by qifu on 17/2/16.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) sign = -1;
        long long_dividend = Math.abs((long) dividend);
        long long_divisor = Math.abs((long) divisor);

        long lans = ldivide(long_dividend, long_divisor);

        int res;
        if(lans > Integer.MAX_VALUE){
            res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            res = (int)(sign * lans);
        }
        return res;
    }

    private long ldivide(long long_dividend, long long_divisor){
        if(long_dividend < long_divisor) return 0;
        int mul = 1;
        long sum = long_divisor;
        while((sum + sum) < long_dividend){
            sum += sum;
            mul += mul;
        }
        return mul + ldivide(long_dividend - sum, long_divisor);
    }
}
