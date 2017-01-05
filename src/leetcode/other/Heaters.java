package leetcode.other;

import java.util.Arrays;

/**
 * Created by qifu on 17/1/5.
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        int result = 0;
        Arrays.sort(heaters);

        for(int house : houses){
            int index = Arrays.binarySearch(heaters, house);
            if(index < 0) {
                index = ~index;

                int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

                result = Math.max(result, Math.min(dist1, dist2));
            }
        }
        return result;
    }
}
