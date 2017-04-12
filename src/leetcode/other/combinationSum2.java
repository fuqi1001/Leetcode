package leetcode.other;

/**
 * Created by qifu on 16/4/4.
 */
import java.util.*;

public class combinationSum2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        generate(candidates,res,new ArrayList<Integer>(),target,0);
        return res;
    }
    private void generate(int[] candidates,List<List<Integer>> res,ArrayList<Integer> cur, int target,int start){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = start ; i < candidates.length;i++){
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }               // remove duplicate
            if(target - candidates[i] < 0 )break;
            cur.add(candidates[i]);
            generate(candidates,res,cur,target-candidates[i],i+1);
            cur.remove(cur.size() - 1);
        }
    }



    //sucks
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, set, cur, 0, 0, target);
        res.addAll(set);
        return res;
    }
    private void helper(int[] nums,Set<List<Integer>> set, List<Integer> cur, int index, int value, int target) {
        if(value == target) {
            set.add(new ArrayList(cur));
        } else if(value > target) return;

        for(int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            value += nums[i];
            helper(nums, set, cur, i+1, value, target);
            cur.remove(cur.size() - 1);
            value -= nums[i];
        }
    }
}
