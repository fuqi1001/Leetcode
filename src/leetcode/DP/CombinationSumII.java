package leetcode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qifu on 16/10/11.
 */
public class CombinationSumII {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            Arrays.sort(candidates);
            helper(candidates,target,0,list,result);
            return result;
        }

    public void helper(int[] candidates,int target,int start,List<Integer> list,List<List<Integer>> result){
        if(target < 0 ) return;
        else if(target == 0) result.add(new ArrayList<>(list));
        else{
            for(int i = start ; i < candidates.length ; i++){
                if(i > start && candidates[i] == candidates[i-1]) continue;
                list.add(candidates[i]);
                helper(candidates,target - candidates[i], i+1, list,result);
                list.remove(list.size()-1);
            }
        }
    }

}
