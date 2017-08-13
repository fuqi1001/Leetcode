package leetcode.other;

/**
 * Created by qifu on 17/8/13.
 */
public class _2KeysKeyboard {
    public int minSteps(int n) {
        if(n == 1) return 0;
        if(n <= 5) return n;
        int count = 0;
        int a = 2;
        while(a * a <= n) {
            while(n % a == 0) {
                count += a;
                n /= a;
            }
            a++;
        }
        if(n > 1) count+= n;
        return count;
    }
}
