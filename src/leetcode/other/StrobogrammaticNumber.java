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
}
