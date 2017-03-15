package leetcode.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by qifu on 16/9/19.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length < 2) return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ;i++){
            if(map.containsKey(nums[i])){
                int n = map.get(nums[i]);
                if(i - n <= k) return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }

    //
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > k) set.remove(nums[i - k - 1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }

}
