package leetcode.z_IXL;

import java.util.HashMap;

/**
 * Created by qifu on 17/4/21.
 */
public class twoSum {

    //O(n)
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
    /*
    for this problem, we just need to go through the array one time,
    and use a hashMap to keep the current num value and the index
    what we need to do just use map to find appropriate value to make it be target
     */


    //do without hashmap

    public int[] twoSum(int[] nums, int target) {
        int max = nums[0];
        int min = nums[0];

        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
        }

        int Min =  Math.min(min,target - max);
        int Max =  Math.max(max,target - min);

        Integer[] map = new Integer[Max - Min + 1];
        target = target - Min;
        for(int i = 0 ; i < nums.length ;i++){
            int key = target - nums[i];
            if(map[key] != null){
                return new int[]{map[key] , i};
            }
            else{
                map[nums[i] - Min] = i;
            }
        }
        return new int[]{-1,-1};
    }

}
