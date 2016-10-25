package leetcode.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/10/25.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums,res,list,0);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int start){
        res.add(new ArrayList<>(list));
        for(int i = start ; i < nums.length ;i++){
            list.add(nums[i]);
            helper(nums,res,list,i+1);
            list.remove(list.size() - 1);
        }
    }

    //
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for(int i = 0 ; i < (1 << len) ;i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0 ; j < len ;j++){
                if((i & (1 <<j)) != 0){
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }

}
