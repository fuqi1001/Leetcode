package leetcode.other;

import java.util.*;

/**
 * Created by qifu on 17/3/13.
 */
public class IntersectionofTwoArraysII {
    //hash
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1) ;
        }
        List<Integer> list = new ArrayList<>();
        for(int num : nums2) {
            if(map.containsKey(num) && map.get(num) != 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int index = 0;
        int[] res = new int[list.size()];
        for(int num : list) {
            res[index++] = num;
        }
        return res;
    }

    //two point
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int point1 = 0;
        int point2 = 0;
        List<Integer> list = new ArrayList<>();
        while((point1 < nums1.length) && (point2 < nums2.length)) {
            if(nums1[point1] < nums2[point2]) {
                point1++;
            } else {
                if(nums1[point1] > nums2[point2]) {
                    point2++;
                } else {
                    list.add(nums1[point1]);
                    point1++;
                    point2++;
                }
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for(int num : list) {
            res[index++] = num;
        }
        return res;
    }
}
