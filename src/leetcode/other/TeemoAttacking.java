package leetcode.other;

/**
 * Created by qifu on 17/2/2.
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0) return 0;
        int begin = timeSeries[0];
        int total = 0;

        for(int cur : timeSeries){
            total += cur < begin + duration ? cur - begin : duration;
            begin = cur;
        }
        return total + duration;

    }
}
