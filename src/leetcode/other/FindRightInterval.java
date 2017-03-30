package leetcode.other;

import java.util.*;

/**
 * Created by qifu on 17/3/30.
 */
public class FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        if(intervals == null || intervals.length <= 1) return new int[]{-1};
        List<Interval> list = new ArrayList<>();
        Map<Interval, Integer> map = new HashMap<>();
        int index = 0;
        for(Interval cur : intervals) {
            list.add(cur);
            map.put(cur, index++);
        }
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int[] res = new int[intervals.length];
        for(int i = 0; i < list.size(); i++) {
            int end = intervals[i].end;
            int start = binary(list, end);
            if(list.get(start).start < end) {
                res[i] = -1;
            } else {
                res[i] = map.get(list.get(start));
            }
        }
        return res;

    }
    private int binary(List<Interval> list, int target) {
        int left = 0, right = list.size() - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid).start < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
