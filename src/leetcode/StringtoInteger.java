package leetcode;

/**
 * Created by qifu on 16/9/22.
 */
public class StringtoInteger {

    public int myAtoi(String str) {
        //empty
        if(str == null || str.length() == 0) return 0;
        //space
        str = str.trim();

        //+ -
        int i = 0;
        boolean positive = true;
        if(str.charAt(i) == '+'){
            i++;
        }else if(str.charAt(i) == '-'){
            positive = false;
            i++;
        }

        //value
        double temp =0;
        for(;i < str.length() ;i++){
            int digit = str.charAt(i) -'0';
            if(digit > 9 || digit < 0) break;

            if(positive){
                temp = temp * 10 +digit;
                if(temp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
            else {
                temp = temp * 10 - digit;
                if(temp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }
        return (int)temp;
    }
}
