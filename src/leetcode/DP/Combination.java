package leetcode.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qifu on 16/10/11.
 */
public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(n,k,1,list,result);
        return result;

    }
    public void helper(int n,int k, int num, List<Integer> list,List<List<Integer>> result){
        if(list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        else{
            for(int i = num; i<= n;i++){
                list.add(i);
                helper(n , k , i+1, list, result);
                list.remove(list.size()-1);
            }
        }
    }
    //===============================================
    public List<List<Integer>> combine(int n , int k){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(n,k,0,list,result);
        return result;
    }
    public void helper(int n,int k, int start, List<List<Integer>> result,List<Integer> list ){
        if(list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        int re = k - list.size();
        for(int i = start; i <= n - re; i++){
            list.add(i+1);
            helper(n,k,i+1,list,result);
            list.remove(list.size() - 1);
        }
    }
}
