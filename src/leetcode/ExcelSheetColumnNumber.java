package leetcode;

/**
 * Created by qifu on 16/8/19.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int len = s.length();
        char[] ctr = new char[len];
        for(int i = 0 ; i < len ;i++){
            ctr[i] = s.charAt(i);
        }
        int result = 0;
        for(int i = 0 ; i < len ;i++){
            result += Math.pow(26,len-1) * (ctr[i]-'A');
        }
        return result;
    }

    public int titleToNumber(String s) {
        int result = 0 ;
        for(int i = 0 ; i < s.length() ;i++){
            result = result * 26 + (s.charAt(i) - 'A') + 1;
        }
        return result;
    }
}
