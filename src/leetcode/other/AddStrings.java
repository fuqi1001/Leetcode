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

    //
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
