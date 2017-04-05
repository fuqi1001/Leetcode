package leetcode.DPandBackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qifu on 17/4/5.
 */
public class Subsets {
    //backtracking
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        helper(set, list, 0, nums);
        List<List<Integer>> res = new ArrayList(set);
        return res;
    }
    private void helper(Set<List<Integer>> res, List<Integer> list, int index, int[] nums) {
        res.add(new ArrayList(list));
        for(int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }

    //bit
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int total = 1 << nums.length;
        for(int i = 0; i < total; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < nums.length; j++) {
                if((i&(1<<j)) != 0) {
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
    /*
        有 total = nums.length 个数 所以有  2^total 种组合方法 => 1 << total
        0) 0 0 0  -> Dont take 3 , Dont take 2 , Dont take 1 = { }
        1) 0 0 1  -> Dont take 3 , Dont take 2 ,   take 1       =  {1 }
        2) 0 1 0  -> Dont take 3 ,    take 2       , Dont take 1 = { 2 }
        3) 0 1 1  -> Dont take 3 ,    take 2       ,      take 1    = { 1 , 2 }
        4) 1 0 0  ->    take 3      , Dont take 2  , Dont take 1 = { 3 }
        5) 1 0 1  ->    take 3      , Dont take 2  ,     take 1     = { 1 , 3 }
        6) 1 1 0  ->    take 3      ,    take 2       , Dont take 1 = { 2 , 3 }
        7) 1 1 1  ->    take 3     ,      take 2     ,      take 1     = { 1 , 2 , 3 }


     */
}
