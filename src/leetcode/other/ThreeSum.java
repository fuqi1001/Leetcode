package leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qifu on 17/2/11.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                int sum = 0 - nums[i];
                int low = i + 1;
                int high = nums.length - 1;

                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    } else if(nums[low] + nums[high] < sum) low++;
                    else high--;
                }
            }
        }
        return res;
    }
}
