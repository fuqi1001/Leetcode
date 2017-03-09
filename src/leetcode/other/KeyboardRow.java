package leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qifu on 17/2/4.
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "QWERTYUIOPqwertyuiop");
        map.put(1, "ASDFGHJKLasdfghjkl");
        map.put(2, "ZXCVBNMzxcvbnm");
        List<String> list = new ArrayList<>();
        int set = -1;

        for(String cur : words){
            if(map.get(0).indexOf(cur.charAt(0)) != -1){
                set = 0;
            }
            if(map.get(1).indexOf(cur.charAt(0)) != -1){
                set = 1;
            }
            if(map.get(2).indexOf(cur.charAt(0)) != -1){
                set = 2;
            }
            for(int i = 1; i < cur.length(); i++){
                int cur_set = -1;

                if(map.get(0).indexOf(cur.charAt(i)) != -1){
                    cur_set = 0;
                }
                if(map.get(1).indexOf(cur.charAt(i)) != -1){
                    cur_set = 1;
                }
                if(map.get(2).indexOf(cur.charAt(i)) != -1){
                    cur_set = 2;
                }

                if(set != cur_set){
                    continue;
                }
            }
            list.add(cur);
        }
        int len = list.size();
        String[] res = new String[len];
        for(int i = 0; i < len; i++){
            res[i] = list.get(i);
        }
        return res;
    }

    //
    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            for(int j = 0; j < strs[i].length(); j++){
                map.put(strs[i].charAt(j), i);
            }
        }
        List<String> list = new ArrayList<>();

        for(String cur : words) {
            if(cur == "") continue;
            String temp = cur.toUpperCase();
            int index = map.get(temp.charAt(0));
            for(int i = 1; i < temp.length(); i++) {
                if(map.get(temp.charAt(i)) != index) {
                    index = -1;
                    break;
                }
            }
            if(index != -1) list.add(cur);
        }
        String[] res = new String[list.size()];
        int index = 0;
        for(String cur : list){
            res[index++] = cur;
        }
        return res;
    }
}
