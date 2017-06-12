package leetcode.DPandBackTracking;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qifu on 17/6/12.
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(k != 0) sum %= k;
            Integer prev = map.get(sum);
            if(prev != null) {
                if(i - prev > 1) return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

    /*
    顺序只扫一遍,从头到尾
    每次得到新数字  加到sum里求余
    如果余数在之前出现过
    证明余数位置index到当前位置i 之间是符合要求的k的某倍
    n*k + 余数 = 当前和

    注意要给map中添加默认 pair (0, -1)
    当找到正好余数是0 的 说明存在符合要求的连续数组

     */
}
