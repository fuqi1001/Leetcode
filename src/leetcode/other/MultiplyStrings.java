package leetcode.other;

/**
 * Created by qifu on 17/2/10.
 */
public class iMultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] number = new int[m+n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int pos1 = i + j;
                int pos2 = i + j + 1;
                int sum = mul + number[pos2];
                number[pos1] += sum / 10;
                number[pos2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int cur : number) {
            if(!(cur == 0 && sb.length() == 0)) {
                sb.append(cur);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
/*
    key point:
    num1中第i位与num2中第j位相乘, 数字会出现在第i+j与第i+j+1位上
     */