package leetcode.other;

/**
 * Created by qifu on 17/5/27.
 */
public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        int min_m = Integer.MAX_VALUE;
        int min_n = Integer.MAX_VALUE;
        if(ops == null || ops.length == 0) return m * n;
        for(int[] cur : ops) {
            min_m = Math.min(min_m, cur[0]);
            min_n = Math.min(min_n, cur[1]);
        }
        return min_m * min_n;
    }
}
