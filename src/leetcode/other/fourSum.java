package leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qifu on 17/2/11.
 */
public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 4) return res;
        Arrays.sort(nums);
        int max = nums[len - 1];
        if(4 * nums[0] > target || 4 * max < target) return res;

        int i, cur;

        for( i = 0; i < len; i++){
            cur = nums[i];
            if(i > 0 && cur == nums[i - 1]) continue;   //duplicate;
            if(cur + 3 * max < target) continue;       //too small;
            if(4 * cur > target) break;                 //to large;
            if(4 * cur == target){
                if(i + 3 < len && nums[i + 3] == cur){  //get one case
                    res.add(Arrays.asList(cur,cur,cur,cur));
                }
                break;
            }
            threeSum(nums, target - cur, i + 1, len - 1, res, cur);
        }
        return res;
    }

    private void threeSum(int[] nums, int target, int low, int high, List<List<Integer>> res, int ori_cur){
        //System.out.println("run in 3sum");
        if(low + 1 >= high) return ;
        int max = nums[high];
        if(3 * max < target || 3 * nums[0] > target) return;

        int i, three_cur;

        for( i = low; i < high - 1; i ++){
            three_cur = nums[i];
            if(i > low && three_cur == nums[i - 1]) continue;   //duplicate;
            if(three_cur + 2 * max < target) continue;          //too small;
            if(3 * three_cur > target) break;                   //to large;
            if(3 * three_cur == target) {
                if(i + 1 < high && nums[i + 2] == three_cur){
                    res.add(Arrays.asList(ori_cur, three_cur, three_cur, three_cur));
                }
                break;
            }
            twoSum(nums, target - three_cur, i + 1, high, res, ori_cur, three_cur);
        }
    }

    private void twoSum(int[] nums, int target, int low, int high, List<List<Integer>> res, int ori_cur, int three_cur){
        //System.out.println("run in 2sum");
        if(low >= high) return;
        if(2 * nums[low] > target || 2 * nums[high] < target) return ;
        int i = low;
        int j = high;
        int sum, x;

        while(i < j){
            sum = nums[i] + nums[j];
            if(sum == target){
                res.add(Arrays.asList(ori_cur,three_cur,nums[i], nums[j]));

                x = nums[i];

                while(++i < j && x == nums[i]);
                while(i < --j && x == nums[j]);
            }
            if(sum < target) i++;
            if(sum > target) j--;
        }
        return;
    }
}
