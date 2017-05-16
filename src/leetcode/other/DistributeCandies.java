package leetcode.other;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qifu on 17/5/16.
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        int half = candies.length / 2;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int cur : candies) {
            if(set.add(cur)) {
                count++;
            }
        }
        return count > half ? half : count;
    }
}
