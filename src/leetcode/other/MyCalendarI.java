package leetcode.other;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarI {
    List<int[]> list;
    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for(int[] cur : list) {
            if(Math.max(start, cur[0]) < Math.min(end, cur[1])) {
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }

    //
    class Interval {
        int start, end;

        public Interval(int start,int end) {
            this.start = start;
            this.end = end;
        }
    }
    List<Interval> list;

    public MyCalendar() {
        list = new ArrayList<Interval>();
    }

    public boolean book(int start, int end) {
        List<Interval> temp_list = new ArrayList<>(list);

        list.add(new Interval(start, end));
        list.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        if(list.size() == 1) return true;
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i).start < list.get(i-1).end) {
                list = temp_list;
                return false;
            }
        }
        return true;
    }

}
