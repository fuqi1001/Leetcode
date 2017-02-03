package leetcode.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by qifu on 17/2/3.
 */
public class MeetingRoomsII {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        //Sort all intervals
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.offer(intervals[0].end);
        for(int i = 1 ; i < intervals.length; i++){
            if(intervals[i].start >= endTimes.peek()){
                endTimes.poll();
            }
            endTimes.add(intervals[i].end);
        }
        return endTimes.size();
    }


    ////
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i = 0 ; i < intervals.length; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int endIndex = 0;
        int room = 0;
        for(int i = 0 ; i < start.length; i++){
            if(start[i] < end[endIndex]){
                room++;
            } else {
                endIndex++;
            }
        }
        return room;
    }
}
