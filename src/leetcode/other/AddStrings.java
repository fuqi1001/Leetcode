package leetcode.other;

/**
 * Created by qifu on 16/12/2.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        int digit = 0;
        while(len1 >= 0 || len2 >= 0){
            int a = len1 >= 0 ? (num1.charAt(len1) - '0') : 0;
            int b = len2 >= 0 ? (num2.charAt(len2) - '0') : 0;
            len1--;
            len2--;

            int cur = a + b + digit;
            if(cur >= 10) {
                cur = cur % 10;
                digit = 1;
            } else{
                digit = 0;
            }
            result.append(String.valueOf(cur));
        }

        if(digit == 1) result.append("1");

        return result.reverse().toString();
    }
}
