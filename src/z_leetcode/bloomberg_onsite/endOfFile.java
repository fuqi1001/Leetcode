package z_leetcode.bloomberg_onsite;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class endOfFile {
    List<int[]> list = new LinkedList<>();

    public void signal(int start, int end) {
        list.add(new int[]{start, end});
        Collections.sort(list, (o1, o2) -> (o1[0] - o2[0]));

        List<int[]> res = new LinkedList<>();
        int[] one = list.get(0);
        int s = one[0];
        int e = one[1];

        for(int[] cur : list) {
            if(cur[0] <= e) {
                e = Math.max(e, cur[1]);
            } else {
                res.add(new int[]{s, e});
                s = cur[0];
                e = cur[1];
            }
        }
        res.add(new int[]{s, e});
        list = res;
    }
    public boolean isFileComplete(int fileSize) {
        if(list.size() == 1 && (list.get(0)[0] == 0 && list.get(0)[1] == fileSize)) return true;
        return false;
    }

    public static void main(String[] args) {
        endOfFile t = new endOfFile();
        t.signal(1,3);
        t.signal(2,6);
        t.signal(8,10);
        t.signal(15,18);
        System.out.println(t.isFileComplete(18));
        for(int[] cur : t.list) {
            System.out.println(cur[0] +" " + cur[1]);
        }
    }
}
