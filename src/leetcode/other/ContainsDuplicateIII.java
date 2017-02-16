package leetcode.other;

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
}
