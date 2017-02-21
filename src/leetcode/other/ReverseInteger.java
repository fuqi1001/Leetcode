package leetcode.other;

/**
 * Created by qifu on 17/2/21.
 */
public class ReverseInteger {
    public int reverse(int x) {
        if(x == 0) return 0;
        int sign = 1;
        if(x < 0){
            x *= -1;
            sign = -1;
        }
        int newNum = 0;
        while(x > 0){
            int temp = newNum * 10 + x % 10;
            if((temp - x % 10) / 10 != newNum) return 0; //overflow
            newNum = temp;
            x /= 10;
        }
        return newNum * sign;
    }
}
