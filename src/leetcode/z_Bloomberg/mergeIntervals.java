package leetcode.z_Bloomberg;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by qifu on 17/3/6.
 */
public class mergeIntervals {
    public class Interval {
             int start;
             int end;
             Interval() { start = 0; end = 0; }
             Interval(int s, int e) { start = s; end = e; }
         }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals.size() <= 1) return intervals;

        Collections.sort(intervals, new Comparator<Interval>(){
            public int  compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval prev = intervals.get(0);
        for(Interval cur : intervals) {
            if(cur.start <= prev.end) {
                prev.end = Math.max(prev.end, cur.end);
            } else {
                res.add(prev);
                prev = cur;
            }
        }
        res.add(prev);
        return res;
    }
}
