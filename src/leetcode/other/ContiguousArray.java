package leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Crino on 2017/4/9.
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        /*
        先把nums中的0全都变成-1；
        这样求和当一串子串和为0时，表示 子串中0 1数量相同
         */
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) nums[i] = -1;
        }
        /*
        将求和的当前index与和存于Map中 方便存取
        如果当前loop的和存在于map中，
        说明上一个和为sum的 index  到cur index 之间的和为 0
        所以 i - map.get(sum)可得到当前段的length
         */
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int res = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum)) {
                res = Math.max(res,i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
