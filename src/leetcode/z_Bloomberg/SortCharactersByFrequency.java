package leetcode.z_Bloomberg;

import java.util.*;

/**
 * Created by qifu on 17/3/6.
 */
public class SortCharactersByFrequency {

        public String frequencySort(String s) {
            if(s == null || s.length() == 0) return "";

            Map<Character, Integer> map = new HashMap<>();
            for(char cur : s.toCharArray()) {
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }

            List<Character>[] bucket = new List[s.length() + 1];
            for(char k : map.keySet()) {
                int freq = map.get(k);
                if(bucket[freq] == null) {
                    bucket[freq] = new ArrayList<>();
                }
                bucket[freq].add(k);
            }

            StringBuilder sb = new StringBuilder();
            for(int i = bucket.length - 1; i > 0; i--){
                if(bucket[i] != null) {
                    for(char k : bucket[i]) {
                        //int freq = map.get(k);
                        for(int j = 0; j < i;j++){
                            sb.append(k);
                        }
                    }
                }
            }
            return sb.toString();
        }
    //other way
    public String frequencySort(String s) {
        if(s.length() <  0) return "";
        int max = 0;
        int[] map = new int[256];
        for(char cur : s.toCharArray()) {
            map[cur]++;
            max = Math.max(map[cur], max);
        }

        String[] bucket = new String[max + 1];
        for(int i = 0; i < 256; i++) {
            String str = bucket[map[i]];
            if(map[i] > 0) {
                bucket[map[i]] = (str == null) ? "" + (char)i : (str + (char)i );
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = max; i >= 0; i--){
            if(bucket[i] != null) {
                for(char cur : bucket[i].toCharArray()) {
                    for(int j = 0 ; j < i; j++){
                        sb.append(cur);
                    }
                }
            }
        }
        return sb.toString();
    }
    //sort number;

    public static int[] frequencySort_num(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }

        List<Integer>[] bucket = new List[max + 1];
        for(int key : map.keySet()) {
            int freq = map.get(key);
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] res = new int[nums.length];

        int index = 0;
        for(int i = max ; i > 0; i--){
            for(int cur : bucket[i]) {
                for(int j = 0; j < i; j++)
                    res[index++] = cur;
            }
        }
        for(int i = 0 ; i < nums.length; i++ ) {
            System.out.print(res[i]+" ");
        }
        return res;
    }
}
