package leetcode.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/10/11.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(k,n,1,list,result);
        return result;

    }

    public void helper(int k,int n, int num, List<Integer> list,List<List<Integer>> result){
        if(n < 0) return ;
        else if(n == 0 && list.size() == k) result.add(new ArrayList<>(list));
        else{
            for(int i = num ; i <= 9 ;i++){
                list.add(i);
                helper(k,n-i,i+1,list,result);
                list.remove(list.size() - 1);
            }
        }

    }
}
