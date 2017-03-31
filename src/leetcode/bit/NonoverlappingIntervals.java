package leetcode.bit;

import leetcode.other.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by qifu on 17/3/31.
 */
public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        int end = intervals[0].end;
        int count = 1;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }
}
