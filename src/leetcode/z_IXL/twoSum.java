package leetcode.z_IXL;

import java.util.HashMap;

/**
 * Created by qifu on 17/4/21.
 */
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(target - nums[i])){
                map.put(nums[i], i);
            } else {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            }
        }
        return res;
    }


}
