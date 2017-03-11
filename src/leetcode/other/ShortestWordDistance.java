package leetcode.other;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by qifu on 16/12/1.
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index = -1;
        int minDis = Integer.MAX_VALUE;

        for(int i = 0 ; i < words.length; i++){
            if(words[i].equals(word1) || words[i].equals(word2)){
                if(index != -1 && !words[index].equals(words[i])){
                    minDis = Math.min(minDis, i - index);
                }
                index = i;
            }
        }
        return minDis;
    }
        ////////
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        int index = 0;
        for(String word : words) {
            if(map.containsKey(word)) {
                map.get(word).add(index++);
            } else {
                map.put(word, new LinkedList<>());
                map.get(word).add(index++);
            }
        }
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int min = Integer.MAX_VALUE;
        for(int i : list1) {
            for(int j : list2) {
                min = Math.min(min, Math.abs(i-j));
            }
        }
        return min;
    }
}
