package leetcode.other;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qifu on 17/4/9.
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        if(wall == null || wall.size() == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int tot = wall.size();
        int length = 0;
        for(List<Integer> list : wall) {
            int prev = 0;
            int temp = 0;
            for(int cur : list) {
                temp += cur;
                prev += cur;
                map.put(prev, map.getOrDefault(prev, 0) + 1);
            }
            length = temp;
        }

        map.remove(length);
        int max = 0;
        for(int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        return max == 0 ? tot : tot - max;
    }
}
