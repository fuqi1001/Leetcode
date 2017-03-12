package leetcode.other;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by qifu on 16/12/1.
 */
public class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
     }
public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals){
        if(intervals == null) return true;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i-1].end){
                return false;
            }
        }
        return true;
    }

    //
    private boolean canAttendMeetings(Interval[] intervals){
        try{
            Arrays.sort(intervals, new IntervalComparator());
        } catch(Exception e){
            return false;
        }
        return true;
    }

    private class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval o1, Interval o2){
            if(o1.start < o2.start && o1.end <= o2.start){
                return -1;
            }
            else if(o1.start >= o2.start && o1.start >= o2.end){
                return 1;
            }
            throw new RuntimeException();
        }
    }
}
