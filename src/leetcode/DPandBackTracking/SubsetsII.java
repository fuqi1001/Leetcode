package leetcode.DPandBackTracking;

import java.util.*;

/**
 * Created by qifu on 17/4/10.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set= new HashSet<>();
        List<Integer> list = new ArrayList<>();
        helper(set, list, nums, 0);
        for(List cur : set) {
            res.add(cur);
        }
        return res;
    }
    private void helper(Set<List<Integer>> set, List<Integer> list, int[] nums, int start){
        set.add(new ArrayList(list));
        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(set,list,nums,i+1);
            list.remove(list.size() - 1);
        }
    }

    //
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res, list, nums, 0);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> list, int[] nums, int start){
        if(start <= nums.length) {
            res.add(new ArrayList<>(list));
        }
        int i = start;
        while(i < nums.length) {
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
            i++;
            while(i < nums.length && nums[i] == nums[i - 1]) i++;
        }
    }
    /*
    少用一个set
    在backchecking里面把重复结果skip掉
     */
}
