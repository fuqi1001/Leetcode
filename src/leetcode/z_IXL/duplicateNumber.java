package leetcode.z_IXL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qifu on 17/4/21.
 */
public class duplicateNumber {
    //直接HashSet
    public List duplicate(int[] number) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(int num : number) {
            if(!set.add(num)) {
                res.add(num);
            }
        }
        return res;
    }

    //数组保存
    public List duplic_array(int[] number) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        List<Integer> res = new ArrayList<>();

        for(int num : number) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        boolean[] count = new boolean[max - min];
        for(int num : number) {
            if(count[num - min]) res.add(num);
            else count[num - min] = true;
        }
        return res;
    }

}
