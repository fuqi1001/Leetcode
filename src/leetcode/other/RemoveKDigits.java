package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/11/21.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if( k >= num.length()) return "0";
        StringBuilder sb = new StringBuilder(num);
        for(int i = 0 ; i < sb.length() - 1; i++){
            while(i >= 0 && i < sb.length() - 1 && k > 0 && sb.charAt(i) > sb.charAt(i + 1)){
                sb.deleteCharAt(i);
                i--;
                k--;
            }
        }
        while(sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.substring(0,sb.length() - k);
    }
}
