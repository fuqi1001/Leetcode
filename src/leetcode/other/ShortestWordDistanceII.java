package leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qifu on 17/1/12.
 */
public class ShortestWordDistanceII {
    HashMap<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0 ; i < words.length; i++){
            String cur = words[i];
            if(map.containsKey(cur)){
                map.get(cur).add(i);
            } else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(cur, list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < list1.size() &&  j < list2.size(); ){
            int index1 = list1.get(i);
            int index2 = list2.get(j);

            if(index1 < index2) {
                res = Math.min(res, index2 - index1);
                i++;
            } else {
                res = Math.min(res, index1 - index2);
                j++;
            }
        }
        return res;
    }
}
