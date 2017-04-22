package leetcode.z_IXL;

/**
 * Created by qifu on 17/4/22.
 */
public class charToInt {
    /*
    1. 去掉起始的空格
    2. 取到正负号
    3. 一组数字构成后,后面多的部分直接舍弃   +12345a213  a213部分无视
     */

    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        str = str.trim();
        boolean positive = true;
        int i = 0;
        if(str.charAt(i) == '+') {
            i++;
        } else if(str.charAt(i) == '-') {
            i++;
            positive = false;
        }

        double temp = 0;
        for(; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            if(digit < 0 || digit > 9) break;   //已经不是数字了
            if(positive) {
                temp = temp * 10 + digit;
                if(temp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            } else {
                temp = temp * 10 - digit;
                if(temp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }
        return (int)temp;
    }
}
