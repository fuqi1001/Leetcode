package leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qifu on 16/9/16.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] word = str.split(" ");
        if( word.length != pattern.length()) return false;

        Map map = new HashMap();
        for(Integer i = 0 ; i < word.length ;i++){
            if(map.put(word[i],i) != map.put(pattern.charAt(i),i)) return false;
        }
        return true;

        //map.put() returns the previous value associated with key,
        //or null if there was no mapping for key.


        //map.containsValue();
        public boolean wordPattern(String pattern, String str) {
            String[] words = str.split(" ");
            Map<Character, String> map = new HashMap<>();
            if(words.length != pattern.length()) return false;
            for(int i = 0; i < pattern.length(); i++){
                char cur = pattern.charAt(i);
                if(map.containsKey(cur)){
                    if(!map.get(cur).equals(words[i])) return false;
                } else {
                    if(map.containsValue(words[i])) return false;
                    map.put(cur, words[i]);
                }
            }
            return true;
        }
    }

}
