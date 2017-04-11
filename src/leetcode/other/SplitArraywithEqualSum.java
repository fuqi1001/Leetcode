package leetcode.other;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qifu on 17/4/11.
 */
public class SplitArraywithEqualSum {
    public boolean splitArray(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        for(int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for(int j = 3; j < len - 3; j++) {
            Set<Integer> set = new HashSet<>();
            for(int i = 1; i < j - 1; i++) {
                if(sum[i-1] == sum[j-1] - sum[i]) set.add(sum[i-1]);
            }
            for(int k = j + 2; k < len - 1; k++) {
                if(sum[k-1] - sum[j] == sum[len - 1] - sum[k] && set.contains(sum[len - 1] - sum[k])) return true;
            }
        }
        return false;
    }
    /*
    思路是:
    先对整个数组求和,每个阶段的和都存到sum[]数组中
    然后把sum[]数组切成四段
    来判断是否存在这四段相等的情况
    因为要求是 (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1)
    所以得到的是
    sum[i-1] == sum[j-1] - sum[i]
    sum[k-1] - sum[j] == sum[len - 1] - sum[k]
    要剔除当前Index的nums值

     */
}
