package leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qifu on 17/1/8.
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character cur : s.toCharArray()){
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }

        List<Character>[] bucket = new List[s.length() + 1];
        for(char key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for(int cur = bucket.length - 1 ; cur >= 0; cur--){
            if(bucket[cur] != null){
                for(char cur_key : bucket[cur]){
                    for(int i = 0 ; i < map.get(cur_key); i++){
                        sb.append(cur_key);
                    }
                }
            }
        }
        return sb.toString();
    }

    ////

    public String frequencySort(String s) {
        if(s.length() < 3) return s;
        int max = 0;
        int[] map = new int[256];
        for(char cur : s.toCharArray()){
            map[cur]++;
            max = Math.max(max, map[cur]);
        }

        String[] bucket = new String[max + 1];
        for(int i = 0 ; i < 256; i++){
            String str = bucket[map[i]];
            if(map[i] > 0){
                bucket[map[i]] = (str == null) ? "" + (char)i : (str + (char)i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = max ; i >= 0; i--){
            if(bucket[i] != null){
                for(char cur : bucket[i].toCharArray()){
                    for(int j = 0 ; j < i; j++){
                        sb.append(cur);
                    }
                }
            }
        }
        return sb.toString();
    }
}
