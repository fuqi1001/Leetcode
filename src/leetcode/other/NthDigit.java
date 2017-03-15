package leetcode.other;

/**
 * Created by qifu on 17/3/15.
 */
public class NthDigit {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;
        while(n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }
        start += --n / len;
        String s = Integer.toString(start);
        return s.charAt(n % len) - '0';
    }
}
