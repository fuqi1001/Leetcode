package leetcode.other;

import java.util.*;

/**
 * Created by qifu on 16/9/29.
 */
public class QueueReconstructionbyHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for(int[] cur : people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }



}
