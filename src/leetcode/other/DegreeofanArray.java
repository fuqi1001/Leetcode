package leetcode.other;

import java.util.*;

public class DegreeofanArray {
    public int findShortestSubArray(int[] nums) {
        if(nums==null || nums.length == 0) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        int count = 0;
        int num = nums.length;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            if(list.size() >= count) {
                Collections.sort(list);
                if(list.size() > count) {
                    num = list.get(list.size() - 1) - list.get(0) + 1;
                } else {
                    num = Math.min(num, list.get(list.size() - 1) - list.get(0) + 1);
                }
                count = list.size();
            }
        }
        return num;
    }
}
