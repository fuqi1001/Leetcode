package leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qifu on 17/3/27.
 */
public class MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == k) max = i + 1;
            else if(map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            /*
            sum - k = prevsum;
            => sum - prevsum = k;
             */
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }


    //
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, i - map.getOrDefault(sum - k, i));
            /*
            map.put(0, -1)
            sum - k = 0;
            => sum = k;
            说明到i位置时, 符合要求  max = i + 1;
            => i - (-1)
             */
            map.putIfAbsent(sum, i);
        }
        return max;
    }
}
