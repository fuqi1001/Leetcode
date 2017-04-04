package leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qifu on 16/12/3.
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int len = num.length();
        int start = 0;
        int end = len - 1;
        Map<Character, Character> map = new HashMap<>();

        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');
        while(start  <= end){
            if(! map.containsKey(num.charAt(start)) || num.charAt(end) != map.get(num.charAt(start) )) return false;

            start++;end--;
        }
        return true;

    }


    //
    public boolean isStrobogrammatic(String num) {
        for(int i = 0 , j = num.length() - 1 ; i <= j ; i++, j--){
            if(!"00 11 88 696".contains(num.charAt(i) +""+num.charAt(j))) return false;
        }
        return true;
    }

    //
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) return true;
        int left = 0;
        int right = num.length() - 1;
        while(left < right) {
            char l = num.charAt(left);
            char r = num.charAt(right);
            if(!helper(l,r)) return false;
            left++;
            right--;
        }
        if(num.length() % 2 != 0) {
            char mid = num.charAt(num.length() / 2);
            if(mid == '1' || mid =='0' || mid == '8') return true;
            else return false;
        }
        return true;
    }
    public boolean helper(char left, char right) {
        if( (left == '6' && right == '9') || (left == '9' && right == '6')) return true;
        if( (left == '8' && right == '8')) return true;
        if( (left == '1' && right == '1')) return true;
        if( (left == '0' && right == '0')) return true;

        return false;
    }
}
