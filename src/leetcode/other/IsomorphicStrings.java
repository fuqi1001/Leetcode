package leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qifu on 16/9/16.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map1= new HashMap<>();
        Map<Character,Character> map2= new HashMap<>();

        for(int i = 0; i < s.length() ;i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map1.containsKey(c1)){
                if(map1.get(c1) != c2) return false;
            }
            if(map2.containsKey(c2)){
                if(map2.get(c2) != c1) return false;
            }
            map1.put(c1,c2);
            map2.put(c2,c1);
        }
        return true;
    }

    //
    public boolean isIsomorphic(String s, String t) {
        int[] pos = new int[512];   //use 0-255 keep s,  256-512 keep t.
        for(int i = 0; i < s.length(); i++) {
            if(pos[s.charAt(i)] != pos[t.charAt(i) + 256]) return false;
            pos[s.charAt(i)] = i + 1;
            pos[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
}
