package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 17/6/8.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long p1 = (long)lower - 1;
        long p2 = 0;

        for(int i = 0; i <= nums.length; i++) {
            if(i == nums.length) {
                p2 = (long)upper + 1;
            } else {
                p2 = nums[i];
            }

            if(p2 == p1 + 2) {
                res.add((p1+1) + "");
            } else if(p2 > p1 + 2) {
                res.add((p1+1) + "->" + (p2 - 1));
            }
            p1 = p2;
        }
        return res;
    }
    //
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int num : nums) {
            if(num == Integer.MIN_VALUE) {
                lower = num + 1;
                continue;
            }
            if(num == lower + 1) res.add("" + lower);
            else if(num - 1 > lower) res.add(lower+"->"+(num - 1));
            if(num == Integer.MAX_VALUE) return res;

            lower = num + 1;
        }

        if(lower == upper) res.add(""+lower);
        else if(lower < upper) res.add(lower +"->" +upper);
        return res;
    }
}
