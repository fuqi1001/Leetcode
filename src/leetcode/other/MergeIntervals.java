package leetcode.other;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qifu on 17/2/8.
 */

public class MergeIntervals {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        List<Interval> res = new LinkedList<>();

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(Interval cur : intervals){
            if(cur.start <= end){
                end = Math.max(cur.end, end);
            } else {
                res.add(new Interval(start, end));
                start = cur.start;
                end = cur.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
