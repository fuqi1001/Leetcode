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
}
