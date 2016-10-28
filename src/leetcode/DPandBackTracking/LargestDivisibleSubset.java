package leetcode.DPandBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qifu on 16/10/27.
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        if(len == 0) return res;
        int[] dp = new int[len];
        int[] index = new int[len];

        Arrays.sort(nums);

        Arrays.fill(dp,1);
        Arrays.fill(index, -1);

        int max_index = 0;
        int max_dp = 1;

        for(int i = 0 ; i < len ;i++){
            for(int j = i - 1; j >= 0 ;j--){
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    index[i] = j;
                } // 只会往前走一步
            }

            if(max_dp < dp[i]){
                max_dp = dp[i];
                max_index = i;
            }
        }

        for(int i = max_index; i != -1; i = index[i]){
            res.add(nums[i]);
        }
        return res;
    }
}
