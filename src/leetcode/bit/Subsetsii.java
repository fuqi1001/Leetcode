package leetcode.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qifu on 16/10/26.
 */
public class Subsetsii {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 || nums == null) return res;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        helper(res,list,nums,0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start){
        res.add(new ArrayList<>(list));
        for(int i = start; i < nums.length ;i++){
            if(i != start && nums[i] == nums[i - 1]){
                continue;
            }

            list.add(nums[i]);
            helper(res,list,nums,i+1);
            list.remove(list.size() - 1);
        }
    }
}
