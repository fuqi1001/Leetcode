package leetcode.bit;

/**
 * Created by qifu on 16/9/20.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for(int i = a.length() -1,j = b.length() -1 ; i>=0 || j>=0; i--,j--){
            int ai = i>=0?a.charAt(i)-'0' : 0;
            int bi = j>=0?b.charAt(j)-'0' : 0;
            int val = (ai+bi+carry) % 2;
            carry = (ai+bi+carry) / 2;
            result.append(val);
        }
        if(carry == 1)
            result.append("1");
        return result.reverse().toString();
    }
}
