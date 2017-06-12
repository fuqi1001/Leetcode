package leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qifu on 17/2/14.
 */
public class CanIWin {
    Map<Integer, Boolean> map;
    boolean[] used;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= 0) return true;
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if(sum < desiredTotal) return false;

        map = new HashMap<>();
        used = new boolean[maxChoosableInteger + 1];
        return helper(desiredTotal);
    }
    public boolean helper(int target) {
        if(target <= 0) return false;
        int key = format(used);
        if(!map.containsKey(key)) {
            for(int i = 1; i < used.length; i++) {
                if(!used[i]) {
                    used[i] = true;
                    if(!helper(target - i)) {
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }
    public int format(boolean[] used) {
        int num = 0;
        for(boolean cur : used) {
            num <<= 1;
            if(cur) {
                num |= 1;
            }
        }
        return num;
    }
    /*
    format() 用于生成一个key
    用来表示整个boolean[] used数组第几位用过第几位没用过
    map里存这个key与true false的键值对
    存储中间过程
     */
}
