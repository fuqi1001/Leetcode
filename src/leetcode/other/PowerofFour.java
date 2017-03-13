package leetcode.other;

/**
 * Created by qifu on 17/3/13.
 */
public class PowerofFour {
    public boolean isPowerOfFour(int num) {
        if(num > 1) {
            while(num % 4 == 0) num /= 4;
        }
        return num == 1;
    }
}
