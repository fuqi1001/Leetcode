package leetcode.DPandBackTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qifu on 16/10/18.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        if(nums == null) return res;
        if(nums.length == 0){
            res.add(new ArrayList<>());
            return res;
        }

        Arrays.sort(nums); // important


        for(int i = 0 ; i < nums.length ;i++){
            visited[i] = 0 ;
        }
        helper(res,list,nums,visited);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> list,int[] nums,int[] visited){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0 ;i < nums.length ;i++){
            if(visited[i] == 1 || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)){
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            helper(res,list,nums,visited);
            list.remove(list.size() - 1);
            visited[i] = 0;

        }
    }
}
