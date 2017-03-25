package leetcode.DPandBackTracking;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by qifu on 17/3/24.
 */
public class MinimumNumberofArrowstoBurstBalloons {
    //greedy
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                return Integer.compare(p1[1], p2[1]);
            }
        });
        int currentEnd = points[0][1];
        int count = 1;
        for(int[] point : points) {
            if(point[0] > currentEnd) {
                count++;
                currentEnd = point[1];
            } else
                continue;
        }
        return count;
    }

    /*
    箭是垂直射的, 如果当前气球起点小于记录的终点, 便可以被当前的射爆
     */
}
