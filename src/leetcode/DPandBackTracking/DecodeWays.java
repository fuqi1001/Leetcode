package leetcode.DPandBackTracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by qifu on 16/11/18.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;

        Set<String> set = new HashSet<>();
        for(int i = 1; i <= 26; i++){
            set.add(String.valueOf(i));
        }

        Map<Integer, Integer> map = new HashMap<>();
        return numDecode(s,0,map,set);
    }

    private int numDecode(String str, int start, Map<Integer, Integer> map, Set<String> set){
        Integer count = map.get(start);
        if(count != null) return count;
        if(start == str.length()) return 1;

        int num = 0;
        if((start + 1 <= str.length()) && set.contains(str.substring(start, start + 1))){
            num += numDecode(str, start + 1, map, set);
        }
        if((start + 2 <= str.length()) && set.contains(str.substring(start, start + 2))){
            num += numDecode(str, start + 2, map, set);
        }

        map.put(start, num);
        return num;

    }
}
