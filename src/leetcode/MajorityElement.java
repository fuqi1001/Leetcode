package leetcode;

import java.util.HashMap;

/**
 * Created by qifu on 16/8/29.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int element : nums){
            if(map.containsKey(element)){
                map.put(element, map.get(element) + 1);
            }
            else{
                map.put(element,1);
            }
        }
        for(int item : map.keySet()){
            if(map.get(item) > len / 2)
                return item;
        }
        return -1;
    }
}
