package leetcode.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qifu on 17/2/2.
 */
public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        findSequence(res, cur, 0, nums);
        List result = new ArrayList(res);
        return result;
    }

    public void findSequence(Set<List<Integer>> res, List<Integer> cur, int index, int[] nums){
        if(cur.size() >= 2){
            res.add(new ArrayList(cur));
        }

        for(int i = index ; i < nums.length; i++){
            if(cur.size() == 0 || cur.get(cur.size() - 1) <= nums[i]){
                cur.add(nums[i]);
                findSequence(res, cur, i+1, nums);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
