package leetcode.other;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by qifu on 17/2/16.
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0) return false;

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];

            if((set.floor(num) != null && num <= t + set.floor(num))
                    || (set.ceiling(num) != null && set.ceiling(num) <= t + num)) return true;
            set.add(num);
            if(i >= k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    //bucket sort
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t < 0) return false;
        long range = (long)t + 1;
        Map<Long, Long> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            long cur = (long)nums[i];
            long index = getIndex(cur, range);
            if(map.containsKey(index)) return true;
            if(map.containsKey(index - 1) && Math.abs(nums[i] - map.get(index - 1)) < range) return true;
            if(map.containsKey(index + 1) && Math.abs(nums[i] - map.get(index + 1)) < range) return true;
            map.put(index, (long)nums[i]);
            if(i >= k) {
                map.remove(getIndex(nums[i - k], range));
            }
        }
        return false;
    }
    public long getIndex(long num, long range) {
        if(num < 0) return (num + 1) / range - 1;
        else return num / range;
    }



}
