package leetcode.other;

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

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0 ;
        for(int ele : nums){
            if(count == 0) {
                candidate = ele;
                count = 1;
            }
            else if (ele == candidate){
                count++;
            }
            else if (ele != candidate){
                count--;
            }
        }
        return candidate;
    }//http://bookshadow.com/weblog/2014/12/22/leetcode-majority-element/
    //test
}
