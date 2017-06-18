package leetcode.other;

/**
 * Created by qifu on 17/6/17.
 */
public class MaximumDistanceinArrays {
    public int maxDistance(int[][] arrays) {
        int res = Integer.MIN_VALUE;
        int max = arrays[0][arrays[0].length - 1];
        int min = arrays[0][0];

        for(int i = 1; i < arrays.length; i++){
            res = Math.max(res, Math.abs(arrays[i][0] - max));
            res = Math.max(res, Math.abs(min - arrays[i][arrays[i].length - 1]));
            max = Math.max(max, arrays[i][arrays[i].length - 1]);
            min = Math.min(min, arrays[i][0]);
        }
        return res;
    }

    //
    public int maxDistance(int[][] arrays) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int index_max = 0;
        int index_min = 0;
        int index = 0;
        for(int[] cur : arrays) {
            if(max < cur[cur.length - 1]) {
                max = cur[cur.length - 1];
                index_max = index;
            }
            if(min > cur[0]) {
                min = cur[0];
                index_min = index;
            }
            index++;
        }
        if(index_max != index_min) {
            return Math.abs(min - max);
        } else {
            // find other max
            int _max = Integer.MIN_VALUE;
            for(int i = 0; i < arrays.length; i++) {
                if(i == index_min) continue;
                _max = Math.max(_max, arrays[i][arrays[i].length - 1]);
            }
            // get other min
            int _min = Integer.MAX_VALUE;
            for(int i = 0; i < arrays.length; i++) {
                if(i == index_max) continue;
                _min = Math.min(_min, arrays[i][0]);
            }
            return Math.abs(min - _max) > Math.abs(_min - max) ? Math.abs(min - _max) : Math.abs(_min - max);
        }
    }
}
