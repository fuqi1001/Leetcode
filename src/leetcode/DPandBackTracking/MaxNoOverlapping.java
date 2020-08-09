package leetcode.DPandBackTracking;

import java.util.HashMap;
import java.util.Map;

public class MaxNoOverlapping {
    // 1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target

    /**
     *
     * @param nums
     * @param target
     * @return
     *
     * To avoid conflict, we want to make the subarray as short as possible. When we use prefixSum,
     * the same prefixSum can have different indices, we want to make sure that certain prefixSum is always mapped
     * to the rightMost index so that the subarray is as short as possible
     *
     */
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, rightMostIdx = -1;
        int res = 0;
        map.put(0, -1);

        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remain = prefixSum - target;

            if (map.containsKey(remain) && map.get(remain) >= rightMostIdx) {
                res++;
                rightMostIdx = i;
            }

            map.put(prefixSum, i);
        }
        return res;
    }


    public int maxNonOverlappingTwo(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int res = 0;
        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - target)) {
                res = Math.max(res, map.get(prefixSum - target) + 1);
            }
            map.put(prefixSum, res);
        }
        return res;
    }
}
