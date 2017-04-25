package leetcode.z_IXL;

/**
 * Created by qifu on 17/4/24.
 */
public class Fibonacci {
    // Version: Recursion
    public static long fibo(long n ) {
        if(n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (n > 1)
            return fibo(n - 1) + fibo(n - 2);
        else
            return -1;
    }
    //  Version: Iteration
    public static long fibonacci(long n) {
        int a = 0, b = 1;
        if (n < 0)
            return -1;
        else if (n == 0)
            return 0;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
