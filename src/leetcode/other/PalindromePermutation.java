package leetcode.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by qifu on 16/11/30.
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            Integer cnt = map.get(c);
            if(cnt == null) {
                cnt = new Integer(0);
            }
            map.put(c,++cnt);
        }

        boolean hasOdd = false;
        for(Character c : map.keySet()){
            if(map.get(c) % 2 != 0){
                if(hasOdd == false){
                    hasOdd = true;
                } else{
                    return false;
                }
            }
        }
        return true;
    }
    ///
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();

        for(int i = 0 ; i < s.length() ;i++){
            char cnt = s.charAt(i);
            if(set.contains(cnt)){
                set.remove(cnt);
            }else{
                set.add(cnt);
            }
        }
        return set.size() <= 1;
    }
}
