package leetcode.Implement;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {

    Map<String, Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int count = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getKey().startsWith(prefix)) {
                count += entry.getValue();
            }
        }
        return count;
    }

}
