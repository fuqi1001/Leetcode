package leetcode.DPandBackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/10/18.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res,list,nums);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> list,int[] nums){
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0 ; i < nums.length ;i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            helper(res,list,nums);
            list.remove(list.size() - 1);
        }
    }

    //non-recursion

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null){
            return res;
        }
        if(nums.length == 0){
            res.add(new ArrayList<>());
            return res;
        }

        int len  = nums.length ;

        List<Integer> stack = new ArrayList<>();

        stack.add(-1);

        while(stack.size() != 0){
            Integer last = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);

            int next = -1;
            for(int i = last + 1; i < len ;i++){
                if(!stack.contains(i)){
                    next = i;
                    break;
                }
            }
            if(next == -1){
                continue;
            }
            stack.add(next);
            for(int i = 0 ; i < len ;i++){
                if(!stack.contains(i)){
                    stack.add(i);
                }
            }
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < len ; i++){
                list.add(nums[stack.get(i)]);
            }
            res.add(list);
        }
        return res;
    }

}
