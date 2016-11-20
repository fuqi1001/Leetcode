package leetcode.other;

import java.util.HashMap;

/**
 * Created by qifu on 16/9/5.
 */
public class TwoSum {
    public int[] twoSum(int[] nums,int target){
        int[] result = new int[2];

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < nums.length ; i++){
            if(!map.containsKey(target - nums[i])){
                map.put(nums[i],i);
            }
            else{
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            }
        }
        return result;
    }

    //https://github.com/BruceZu/sawdust/blob/master/dataStructuresAndAlgorithms/src/main/java/array/Leetcode1twoSum.java
    //unclear
    public int[] twoSum(int[] nums, int target){
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
