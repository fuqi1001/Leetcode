package leetcode.other;

import java.util.*;

/**
 * Created by qifu on 17/3/10.
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        if(nums==null || nums.length == 0) return res;

        TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i] , i);
        }
        int count = 1;

        for(int key : map.keySet()) {
            if(count == 1) {
                res[map.get(key)] = "Gold Medal";
            } else if(count == 2) {
                res[map.get(key)] = "Silver Medal";
            } else if(count == 3) {
                res[map.get(key)] = "Bronze Medal";
            } else {
                res[map.get(key)] = String.valueOf(count);
            }
            count++;
        }
        return res;
    }

    //
    public String[] findRelativeRanks(int[] nums) {
        if(nums == null || nums.length == 0) return new String[0];
        int n = nums.length;
        String[] result = new String[n];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < n; ++i){
            map.put(nums[i], i);
        }


        Arrays.sort(nums);
        for( int i = 0; i < n/2; ++i ) {
            int temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }

        result[map.get(nums[0])] = "Gold Medal";
        if(1 < n) result[map.get(nums[1])] = "Silver Medal";
        if(2 < n) result[map.get(nums[2])] = "Bronze Medal";
        for(int j = 3; j < n; ++j){
            result[map.get(nums[j])] = String.valueOf(j + 1);
        }
        return result;
    }

    //
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        if(nums == null || nums.length == 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        res[map.get(nums[nums.length - 1])] = "Gold Medal";
        if(nums.length - 2 >= 0) res[map.get(nums[nums.length - 2])] = "Silver Medal";
        if(nums.length - 3 >= 0) res[map.get(nums[nums.length - 3])] = "Bronze Medal";
        int count = 4;
        for(int i = nums.length - 4; i >= 0; i--){
            res[map.get(nums[i])] = String.valueOf(count);count++;
        }
        return res;
    }
}
