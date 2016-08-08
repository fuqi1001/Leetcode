package leetcode;

/**
 * Created by qifu on 16/8/8.
 */
public class ReverseString {
    public String reverseString(String s) {
        char[] str = s.toCharArray();
        int len = s.length()-1;
        int n = 0;
        char[] newStr = new char[len+1];

        for(int i = len; i >= 0 ; i--){
            newStr[n] = str[i];
            n++;
        }
        return new String(newStr);
    }
}
