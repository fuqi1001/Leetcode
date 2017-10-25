package leetcode.other;

import java.util.*;

/**
 * Created by qifu on 16/8/29.
 */
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            count[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < s.length() ; i++){
            if(count[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }


    ///
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                map.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
                map.put(s.charAt(i), i);
            }
        }

        if(map.size() == 0) return -1;
        int res = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            res = entry.getValue();
            break;
        }
        return res;
    }

    //
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int len = s.length();
        if(len == 1) return 0;
        int slow = 0, fast = 1;
        char[] ctr = s.toCharArray();
        int[] count = new int[256];
        count[ctr[slow]]++;
        while(fast < len) {
            count[ctr[fast]]++;
            while( slow < len && count[ctr[slow]] > 1) slow++;
            if(slow >= len)  return -1;
            if(count[ctr[slow]] == 0) {
                count[ctr[slow]]++;
                fast = slow;
            }
            fast++;
        }
        return slow;
    }
}
