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
        if(s == null || s.length() == 0) return 0;
        Set<String> set = new HashSet<>();
        for(int i = 1; i <= 26; i++) {
            set.add(String.valueOf(i));
        }
        Map<Integer,Integer> map = new HashMap<>();
        return helper(s, 0, map, set);
    }
    public int helper(String s, int index, Map<Integer, Integer> map, Set<String> set) {
        Integer count = map.get(index);
        if(count != null) return count;
        if(index == s.length()) return 1;
        int num = 0;
        if((index + 1 <= s.length()) && set.contains(s.substring(index, index+1))) {
            num += helper(s, index + 1, map, set);
        }
        if((index + 2 <= s.length()) && set.contains(s.substring(index, index+2))) {
            num += helper(s, index + 2, map, set);
        }
        map.put(index, num);
        return num;
    }
}
