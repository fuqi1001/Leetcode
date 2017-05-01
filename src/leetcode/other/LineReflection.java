package leetcode.other;

import java.util.HashSet;

/**
 * Created by qifu on 17/2/7.
 */
public class LineReflection {
    public boolean isReflected(int[][] points){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();


        for(int[] pair : points){
            max = Math.max(max, pair[0]);
            min = Math.min(min, pair[0]);

            String str = pair[0] + "a" + pair[1];
            set.add(str);
        }
        /*
        此处的sum/2 相当于中线
        sum-x 会得到与之对称的点的很坐标
         */
        int sum = max + min;
        for(int[] pair : points){
            String str_o = (sum-pair[0]) + "a" + pair[1];
            if(!set.contains(str_o)) return false;
        }
        return true;
    }
}
