package leetcode.z_twoSigma;

import java.util.*;

/**
 * Created by qifu on 17/2/15.
 */
public class longestChain {
    public static int longestchain(String[] words) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        //sort the String array and get set;

        set = sort(words);

        int res = 0;
        for(String word: set){
            if(word.length() < res){
                continue;
            }
            int len = helper(word, set, map) + 1;
            map.put(word, len);
            res = Math.max(res, len);
        }
        return res;
    }
    private static Set<String> sort(String[] words){
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() < o2.length()) return -1;
                else if(o1.length() > o2.length()) return 1;
                return o1.compareTo(o2);
            }
        });
        for(String s: words){
            set.add(s);
        }
        return set;
    }

    private static int helper(String s, Set<String> set, Map<String, Integer> map){
        int res = 0;
        for(int i = 0; i < s.length() ;i++){
            String cur_str = s.substring(0,i) + s.substring(i+1);
            if(set.contains(cur_str)){
                if(map.containsKey(cur_str)){
                    res = Math.max(res, map.get(cur_str));
                } else {
                    res = Math.max(res, helper(cur_str, set, map) + 1);
                }
            }
        }
        return res;
    }
}
