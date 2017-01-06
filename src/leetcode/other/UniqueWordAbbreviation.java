package leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qifu on 17/1/6.
 */
public class UniqueWordAbbreviation {
    Map<String, String> map;
    public ValidWordAbbr(String[] dictionary){
        map = new HashMap<>();

        for(String cur : dictionary){
            String key = getKey(cur);
            if(map.containsKey(key)){
                if(!map.get(key).equals(cur)){
                    map.put(key,"");
                }
            }else{
                map.put(key, cur);
            }
        }
    }
    public boolean isUnique(String word){
        return !map.containsKey(getKey(word)) || map.get(getKey(word)).equals(word);
    }
    private String getKey(String str){
        if(str.length() <= 2) return str;
        else{
            return str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() - 1);
        }
    }
}
