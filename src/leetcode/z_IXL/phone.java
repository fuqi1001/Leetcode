package leetcode.z_IXL;

import java.util.HashMap;

/**
 * Created by qifu on 17/4/25.
 */
public class phone {
    public HashMap change(HashMap<String, HashMap<String, Integer>> map) {
        HashMap<String, HashMap<String, Integer>> res = new HashMap<>();
        for(String first_name : map.keySet()) {
            HashMap<String, Integer> cur = map.get(first_name);
            for(String last_name : cur.keySet()) {
                if(res.containsKey(last_name)) {
                    res.get(last_name).put(first_name, cur.get(last_name));
                } else {
                    HashMap<String, Integer> temp = new HashMap<>();
                    temp.put(first_name, cur.get(last_name));
                    res.put(last_name, temp);
                }
            }
        }
        return res;
    }
}
