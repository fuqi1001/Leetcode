package leetcode.Implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by qifu on 17/7/1.
 */
public class DesignLogStorageSystem {
    private static List<String> GRAS = Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second");
    private static String[] MAX_VALS = new String[] {"2017", "12", "31", "23", "60", "60"};
    private TreeMap<String, List<Integer>> logs;

    public DesignLogStorageSystem() {
        logs = new TreeMap<>();
    }

    public void put(int id, String timestamp) {
        if(!logs.containsKey(timestamp)) {
            logs.put(timestamp, new ArrayList<>());
        }
        logs.get(timestamp).add(id);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> ids = new ArrayList<>();
        String[] sVals = s.split(":", 6);
        String[] eVals = e.split(":", 6);
        for(int i = GRAS.indexOf(gra) + 1; i < GRAS.size(); i++) {
            sVals[i] = "00";
            eVals[i] = MAX_VALS[i];
        }
        for(List<Integer> curr_ids : logs.subMap(String.join(":", sVals), true, String.join(":", eVals), true).values()) {
            ids.addAll(curr_ids);
        }
        return ids;
    }
}
