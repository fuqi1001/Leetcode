package leetcode.other;

/**
 * Created by qifu on 16/11/19.
 */
public class Pow {
    public double myPow(double x, int n) {
        if(x == 0.0) return 0;
        if(n == 0) return 1;

        if(n % 2 == 0) return myPow(x * x, n / 2);
        else{
            return (n > 0 ? x : 1.0/x) * myPow(x * x, n / 2);
        }
    }

    public double myPow(double x, int n) {
        double res = 1;
        for(int m = n ; m != 0; m /= 2){
            if(m % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return n > 0 ? res : 1.0 / res;
    }
}
