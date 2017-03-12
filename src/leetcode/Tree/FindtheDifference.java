package leetcode.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qifu on 17/3/12.
 */
public class FindtheDifference {
    //bit
    public char findTheDifference(String s, String t) {
        char c = 0;
        for(int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
        }
        for(int i = 0; i < t.length(); i++) {
            c ^= t.charAt(i);
        }
        return c;
    }



    //

    public char findTheDifference(String s, String t) {
        //if(s == null || s.length() == 0) return ' ';
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        char res = ' ';
        for(int i = 0 ; i < t.length(); i++) {
            char cur = t.charAt(i);
            if(!map.containsKey(cur)) return cur;
            else {
                map.put(cur, map.get(cur) - 1);
            }
        }
        for(char key : map.keySet()) {
            if(map.get(key) != 0) return key;
        }
        return res;

    }

    //

    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for(int i = 0; i < 26; i++){
            count[i] = 0;
        }
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            count[cur - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            char cur = t.charAt(i);
            if(--count[cur - 'a'] < 0) {

                return cur;
            }
        }
        return ' ';
    }
}
