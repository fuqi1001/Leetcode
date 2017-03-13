package leetcode.other;

/**
 * Created by qifu on 17/3/13.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        for(int i = 2; i < 6 && num > 1; i++) {
            while(num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
