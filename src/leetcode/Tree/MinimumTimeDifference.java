package leetcode.Tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qifu on 17/3/11.
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        Map<String, Integer> map = new HashMap<>();
        for(String cur : timePoints) {
            String[] time = cur.split(":");
            int hour = Integer.valueOf(time[0]);
            int minute = Integer.valueOf(time[1]);
            int temp = hour * 60 + minute;
            if(map.containsKey(cur)) return 0;
            map.put(cur, temp);
        }
        int min = Integer.MAX_VALUE;
        for(String key1 : map.keySet()) {
            int time1 = map.get(key1);
            for(String key2 : map.keySet()) {
                if(key1.equals(key2)) continue;
                int time2 = map.get(key2);
                int count = Math.abs(time1 - time2);
                if(count > 720) {
                    if(time1 > 720) {
                        count = 1440 - time1 + time2;
                    } else {
                        count = 1440 - time2 + time1;
                    }
                }

                min = Math.min(count, min);
            }
        }
        return min;
    }


}
