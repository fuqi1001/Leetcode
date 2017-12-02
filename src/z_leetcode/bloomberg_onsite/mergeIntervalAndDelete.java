package z_leetcode.bloomberg_onsite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mergeIntervalAndDelete {
    public String deleteCharacter(String str, List<int[]> list) {
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> interval = new ArrayList<>();
        int start = list.get(0)[0];
        int end = list.get(0)[1];

        for(int i = 1; i < list.size(); i++) {
            if(list.get(i)[0] < end) {
                end = Math.max(list.get(i)[1], end);
            } else {
                interval.add(new int[] {start, end});
                start = list.get(i)[0];
                end = list.get(i)[1];
            }
        }
        interval.add(new int[] {start, end});
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for(int[] cur : interval) {
            sb.append(str.substring(index, cur[0]));
            index = cur[1] + 1;
        }
        return sb.append(str.substring(index)).toString();
    }
}
