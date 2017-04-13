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
        if(nums == null || nums.length == 0) return res;
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        helper(res, cur, nums, visited);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int[] visited) {
        if(cur.size() == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == 1 || (i!=0 &&nums[i] == nums[i-1] && visited[i-1] == 1)) continue;

            visited[i] = 1;
            cur.add(nums[i]);
            helper(res, cur, nums, visited);
            cur.remove(cur.size() - 1);
            visited[i] = 0;
        }
    }
}
